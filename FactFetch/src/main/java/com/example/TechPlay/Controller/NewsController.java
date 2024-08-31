package com.example.TechPlay.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.*;


@Controller
@CrossOrigin
public class NewsController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${newsapi.api.key}")
    private String apiKey;

    private final String BASE_URL = "https://newsapi.org/v2/";



    @GetMapping("/news/top-headlines")
    @ResponseBody
    public List<Map<String, String>> getTopHeadlines() throws IOException {
        String url = BASE_URL + "top-headlines?country=us&category=technology&category=sports&apiKey=" + apiKey;
        String response = restTemplate.getForObject(url, String.class);

        // Parse the JSON response
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response);
        JsonNode articlesNode = rootNode.path("articles");

        List<Map<String, String>> filteredHeadlines = new ArrayList<>();
        int count = 0;

        // Iterate through the articles and filter the headlines
        for (JsonNode articleNode : articlesNode) {
            if (count >= 25) break; // Limit to first 25 articles

            String headline = articleNode.path("title").asText();
            String articleUrl = articleNode.path("url").asText();

            Map<String, String> articleInfo = new HashMap<>();
            articleInfo.put("headline", headline);
            articleInfo.put("url", articleUrl);

            filteredHeadlines.add(articleInfo);
            count++;
        }

        return filteredHeadlines;
    }

//    @GetMapping("/home")
//    public String home(){
//        return "HomePage";
//    }


}

