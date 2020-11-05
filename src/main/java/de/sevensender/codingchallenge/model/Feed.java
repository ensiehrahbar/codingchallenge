package de.sevensender.codingchallenge.model;

import com.rometools.rome.feed.synd.SyndContent;

import java.util.Date;

public class Feed {

    private String title;
    private String webUrlForBrowserView;
    private Date publishingDate;
    private String imageUrl;

    public Feed(String title, String webUrlForBrowserView, Date publishingDate, String imageUrl
    ) {
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

    public Date getPublishingDate() {
        return publishingDate;
    }

    public String getWebUrlForBrowserView() {
        return webUrlForBrowserView;
    }

    public void setTitle() {
        this.title = title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public void setWebUrlForBrowserView(String webUrlForBrowserView) {
        this.webUrlForBrowserView = webUrlForBrowserView;
    }
}
