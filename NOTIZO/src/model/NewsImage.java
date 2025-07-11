package model;

public class NewsImage {
    private String url;
    private String imageDescription;
    private String caption;
    private int width;
    private int height;
    private String newId;

    public NewsImage(String url, String imageDescription, String caption, 
                    int width, int height, String newId) {
        this.url = url;
        this.imageDescription = imageDescription;
        this.caption = caption;
        this.width = width;
        this.height = height;
        this.newId = newId;
    }

    // Getters
    public String getUrl() { return url; }
    public String getImageDescription() { return imageDescription; }
    public String getCaption() { return caption; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public String getNewId() { return newId; }

    // Setters
    public void setUrl(String url) {
        if (url == null) {
            throw new IllegalArgumentException("The url cannot be empty.");
        }
        this.url = url;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public void setCaption(String caption) {
        if (caption == null) {
            throw new IllegalArgumentException("The caption cannot be empty.");
        }
        this.caption = caption;
    }

    public void setWidth(int width) {
        if (width <= 0) {
            throw new IllegalArgumentException("The width cannot be negative or zero.");
        }
        this.width = width;
    }

    public void setHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("The height cannot be negative or zero.");
        }
        this.height = height;
    }

    public void setNewId(String newId) {
        this.newId = newId;
    }
}