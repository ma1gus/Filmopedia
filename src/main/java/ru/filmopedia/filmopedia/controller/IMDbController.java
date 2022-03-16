package ru.filmopedia.filmopedia.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.filmopedia.filmopedia.config.IMDbSearchConfig;
import ru.filmopedia.filmopedia.models.Film;
import ru.filmopedia.filmopedia.models.URLOfSearchIMDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@Controller
@SuppressWarnings(value = "unchecked")
public class IMDbController {

    private List<Film> list = (List<Film>) IMDbSearchConfig.switchOfSearchUrl(URLOfSearchIMDB.URL_SEARCH_FILM, "nachalo");

    @GetMapping("/")
    public String nachalo(Model model) {
        model.addAttribute("films", list);
        return "index";
    }

    @GetMapping("/search")
    public String getFilmFromSearch(@RequestParam(value = "film_name") String filmName, Model model) {
        list = (List<Film>) IMDbSearchConfig.switchOfSearchUrl(URLOfSearchIMDB.URL_SEARCH_FILM, filmName);;
        return "redirect:/";
    }

}
