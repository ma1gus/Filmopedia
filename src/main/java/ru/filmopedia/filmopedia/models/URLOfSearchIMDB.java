package ru.filmopedia.filmopedia.models;

public enum URLOfSearchIMDB {
    URL_SEARCH_FILM("https://imdb-api.com/en/API/SearchMovie/k_zima5p9v/"),
    URL_SEARCH_FILM_BY_ID("https://imdb-api.com/ru/API/title/k_zima5p9v/");
    //актер, режиссер
    private final String url;

    URLOfSearchIMDB(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
