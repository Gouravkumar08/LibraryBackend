package com.gourav.Library_Management_System.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class FreeAIService {
    private final RestTemplate restTemplate;

    @Value("${gemini.api.key}")
    private String apiKey;

    private static final String API_URL =
            "https://generativelanguage.googleapis.com/v1/models/gemini-1.5-flash:generateContent";

    public FreeAIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String generateBookInsights(String title, String author, String description) {
        if (title == null || author == null || description == null) {
            return "Please provide complete book details";
        }

        String prompt = String.format(
                "Generate a 100-word summary of '%s' by %s. Description: %s. " +
                        "Focus on key themes and why readers might enjoy it.",
                title, author, description);

        Map<String, Object> request = Map.of(
                "contents", List.of(
                        Map.of("parts", List.of(
                                Map.of("text", prompt)
                        ))
                )
        );

        try {
            String url = API_URL + "?key=" + apiKey;

            ResponseEntity<Map> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    new HttpEntity<>(request),
                    Map.class
            );

            // Proper type casting with null checks
            Map<String, Object> responseBody = response.getBody();
            if (responseBody != null && responseBody.containsKey("candidates")) {
                List<Map<String, Object>> candidates = (List<Map<String, Object>>) responseBody.get("candidates");
                if (!candidates.isEmpty()) {
                    Map<String, Object> content = (Map<String, Object>) candidates.get(0).get("content");
                    List<Map<String, String>> parts = (List<Map<String, String>>) content.get("parts");
                    if (!parts.isEmpty()) {
                        return parts.get(0).get("text");
                    }
                }
            }
            return "Could not generate insights from the API response";
        } catch (Exception e) {
            return "Error generating insights: " + e.getMessage();
        }
    }
}