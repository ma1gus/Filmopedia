package ru.filmopedia.filmopedia.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.filmopedia.filmopedia.models.Film;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IMDbSearchConfig {

    private final static String URL_SEARCH_FILM = "https://imdb-api.com/en/API/SearchMovie/k_zima5p9v/";

    private static Map<String, Object> getInputStream(URL url) {
        Map<String, Object> result = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            result = new ObjectMapper().readValue(bufferedReader, HashMap.class);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static List<Film> getFilmsBySearch(String filmName) {
        List<Map<String,String>> nachaloResult = (List<Map<String, String>>) getInputStream(filmName).get("results");

        List<Film> films = new ArrayList<>();
        nachaloResult.forEach(x -> films.add(new Film(x)));

        return films;
    }

//    try {
//        http = (HttpURLConnection) url.openConnection();
//        http.setRequestMethod("GET");
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(http.getInputStream()));
//
//
//        Map<String,Object> result =
//                new ObjectMapper().readValue(bufferedReader, HashMap.class);
//
//        List<Map<String,String>> nachaloResult = (List<Map<String, String>>) result.get("results");
//
//
//
//        bufferedReader.close();
//        List<Film> films = new ArrayList<>();
//        nachaloResult.forEach(x -> films.add(new Film(x)));
//
//    } catch (IOException e) {
//        e.printStackTrace();
//    }


}
