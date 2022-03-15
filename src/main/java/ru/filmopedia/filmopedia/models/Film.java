package ru.filmopedia.filmopedia.models;

import java.util.Map;

public class Film {

    private String id;
    private String title;
    private String image;
    private String resultType;
    private String description;

    public Film(Map<String, String> map) {
        id = map.get("id");
        title = map.get("title");
        image = map.get("image");
        resultType = map.get("resultType");
        description = map.get("description");

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
