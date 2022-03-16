package ru.filmopedia.filmopedia.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.filmopedia.filmopedia.config.IMDbSearchConfig;
import ru.filmopedia.filmopedia.models.Film;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IMDbController {
    @GetMapping("/")
    public String nachalo(@RequestParam(value = "film_name") String filmName, Model model) {
        model.addAttribute("films", IMDbSearchConfig.getFilmsBySearch(filmName));
        return "index";
    }

}
