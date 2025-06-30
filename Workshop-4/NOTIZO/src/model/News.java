package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class News {
    private String newId;
    private String title;
    private String content;
    private LocalDate date;
    private boolean isFeaturedNew;
    private String author;
    private NewsImage image;

    public News(String newId, String title, String content, String dateString, 
                String author, boolean isFeaturedNew, NewsImage image) {
        this.newId = newId;
        this.title = title;
        this.content = content;
        this.date = validateDate(dateString);
        this.author = author;
        this.isFeaturedNew = isFeaturedNew;
        this.image = image;
    }

    private LocalDate validateDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (dateString == null) {
            throw new IllegalArgumentException("The date cannot be empty.");
        }
        try {
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("The date format is incorrect. Try (dd/MM/yyyy)");
        }
    }

    public String getSummary() {
        int maxCharacters = 150;
        String summaryContent = content.length() >= maxCharacters ? 
            content.substring(0, maxCharacters) + "..." : content;
        return title + " - " + author + ": " + summaryContent;
    }

    // Getters
    public String getNewId() { return newId; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public LocalDate getDate() { return date; }
    public boolean isFeaturedNew() { return isFeaturedNew; }
    public String getAuthor() { return author; }
    public NewsImage getImage() { return image; }

    // Setters
    public void setNewId(String newId) {
        if (newId == null || newId.isEmpty()) {
            throw new IllegalArgumentException("The id cannot be empty.");
        }
        this.newId = newId;
    }

    public void setTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("The title cannot be null.");
        }
        this.title = title;
    }

    public void setContent(String content) {
        if (content == null) {
            throw new IllegalArgumentException("The content cannot be null.");
        }
        this.content = content;
    }

    public void setDate(String dateString) {
        this.date = validateDate(dateString);
    }

    public void setFeaturedNew(boolean featured) {
        this.isFeaturedNew = featured;
    }

    public void setAuthor(String author) {
        this.author = author == null ? "anonymous" : author;
    }

    public void setImage(NewsImage image) {
        this.image = image;
    }
}