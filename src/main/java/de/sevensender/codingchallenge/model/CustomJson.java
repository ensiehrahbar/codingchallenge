package de.sevensender.codingchallenge.model;

import com.rometools.rome.feed.synd.SyndContent;

import java.util.Date;
import java.util.Objects;

public final class CustomJson {
    private final String title;
    private final String browserViewURL;
    private final Date publishingDate;
    private final String imageURL;

    public CustomJson(String title, String browserViewURL, Date publishingDate, String imageURL) {
        this.title = title;
        this.imageURL = imageURL;
        this.publishingDate = publishingDate;
        this.browserViewURL = browserViewURL;
    }

    public final String getTitle() {
        return title;
    }

    public final String getImageURL() {
        return imageURL;
    }

    public final Date getPublishingDate() {
        return publishingDate;
    }

    public final String getBrowserViewURL() {
        return browserViewURL;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("picture url=").append(imageURL);
        sb.append(", title / description='").append(title).append('\'');
        sb.append(", web url for browser view=").append(browserViewURL);
        sb.append(", publishing date=").append(publishingDate);
        sb.append('}');
        return sb.toString();
    }
}
