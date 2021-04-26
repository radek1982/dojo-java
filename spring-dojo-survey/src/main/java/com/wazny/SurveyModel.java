package com.wazny;

public class SurveyModel {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDojoLocation() {
        return dojoLocation;
    }

    public void setDojoLocation(String dojoLocation) {
        this.dojoLocation = dojoLocation;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    String name;
    String dojoLocation;
    String favoriteLanguage;
    String comment;
}
