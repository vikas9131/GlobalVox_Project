package com.example.demo.controller;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.geocoderesponse.GeocodeResponce;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class GeocodingController {

	

	    private static final String OPENSTREETMAP_API_ENDPOINT = "https://nominatim.openstreetmap.org/search?q=%s&format=json";

	    @GetMapping("/geocode")
	    public GeocodeResponce getGeocode(@RequestParam String address) throws IOException, InterruptedException {
	        String url = String.format(OPENSTREETMAP_API_ENDPOINT, address);
	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(url))
	                .build();
	        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode rootNode = mapper.readTree(response.body());
	        JsonNode firstResultNode = rootNode.get(0);
	        String latitude = firstResultNode.get("lat").asText();
	        String longitude = firstResultNode.get("lon").asText();
	        return new GeocodeResponce(latitude, longitude);
	    }
	}

	
//
//"lat": "22.705243",
//"lon": "75.864121",
//22.7424358,75.8764227
