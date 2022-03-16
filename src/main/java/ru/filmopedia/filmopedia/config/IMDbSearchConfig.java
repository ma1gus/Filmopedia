package ru.filmopedia.filmopedia.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import ru.filmopedia.filmopedia.models.Film;
import ru.filmopedia.filmopedia.models.URLOfSearchIMDB;

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

    //передать урл, передать реквест - получить джсон
    public static Object switchOfSearchUrl(URLOfSearchIMDB url, String request) {
        switch (url) {
            case URL_SEARCH_FILM -> {
                return getFilmsBySearch(url.getUrl() + request);
                //case URL_SEARCH_FILM_BY_ID ->;
            }
            case URL_SEARCH_FILM_BY_ID -> {
                return getFilmsBySearchByID(url.getUrl() + request);
            }
        }

        return request;
    }

    private static Object getFilmsBySearchByID(String film_id) {
        return "";
    }

    private static Map<String, Object> getInputStream(String url) {
        Map<String, Object> result = null;
        try {
            URL urlAA = null;
            try {
                urlAA = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlAA.openConnection();
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
