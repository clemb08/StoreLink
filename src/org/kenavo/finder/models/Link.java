package org.kenavo.finder.models;

import java.util.List;

public class Link {

    private String Id;
    private String Title;
    private String Link;
    private String Description;
    private List<String> Keywords;

    public Link(){

    }

    public Link(String id, String title, String link, String description, List<String> keywords) {
        Id = id;
        Title = title;
        Link = link;
        Description = description;
        Keywords = keywords;
    }

    public String getId() {
        return Id;
    }

    public void setId(String title) {
        Id = title + (Math.random() * (10000 + 1) + 0);
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<String> getKeywords() {
        return Keywords;
    }

    public void setKeywords(List<String> keywords) {
        Keywords = keywords;
    }
}
