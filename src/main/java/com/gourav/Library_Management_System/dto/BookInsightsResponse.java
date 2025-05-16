// BookInsightsResponse.java
package com.gourav.Library_Management_System.dto;

import lombok.Data;

@Data
public class BookInsightsResponse {
    public BookInsightsResponse(Long id, String title, String author, String description, String insights) {
        this.bookId = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.aiInsights = insights;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getAiInsights() {
        return aiInsights;
    }

    public void setAiInsights(String aiInsights) {
        this.aiInsights = aiInsights;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private Long bookId;
    private String title;
    private String author;
    private String description;
    private String aiInsights;
}