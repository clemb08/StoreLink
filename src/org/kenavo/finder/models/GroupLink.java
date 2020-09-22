package org.kenavo.finder.models;

import java.util.ArrayList;
import java.util.List;

public class GroupLink {

    private String Id;
    private String Title;
    private String Link;
    private String Description;
    private List<String> Keywords;
    private List<Link> links = new ArrayList<Link>();

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public List<org.kenavo.finder.models.Link> getLinks() {
        return links;
    }

    public void setLinks(List<org.kenavo.finder.models.Link> links) {
        this.links = links;
    }

    public void addLinks (Link link) {
        links.add(link);
    }
}
