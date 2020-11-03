package de.sevensender.codingchallenge.model;

public class Feed {

    private final String title;
    private final String imageUrl;
    private final String publishingDate;
    private final String webUrlForBrowserView;

    public Feed(String title, String imageUrl, String publishingDate, String webUrlForBrowserView) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.publishingDate = publishingDate;
        this.webUrlForBrowserView = webUrlForBrowserView;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPublishingDate() {
        return publishingDate;
    }

    public String getWebUrlForBrowserView() {
        return webUrlForBrowserView;
    }
}
