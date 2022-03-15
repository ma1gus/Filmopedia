package ru.filmopedia.filmopedia.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/nachalo")
    public String main(Model model) {
        return "index";
    }

    @GetMapping("/")
    public String nachalo(Model model) {
        try {
            HttpURLConnection http;
            URL url = new URL("https://imdb-api.com/en/API/SearchMovie/k_zima5p9v/inception");
            try {
                http = (HttpURLConnection) url.openConnection();
                http.setRequestMethod("GET");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(http.getInputStream()));


                Map<String,Object> result =
                        new ObjectMapper().readValue(bufferedReader, HashMap.class);

                List<Map<String,Object>> nachaloResult = (List<Map<String, Object>>) result.get("results");



                bufferedReader.close();
                List<Film> films = new ArrayList<>();
                nachaloResult.forEach(x -> films.add(new Film(x)));
                result.forEach( (x, y) -> System.out.println(x + " " + y));
                model.addAttribute("films", films);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        return "index";
    }

}
