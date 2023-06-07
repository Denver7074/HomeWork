package com.example.demo.services;

import com.example.demo.configuration.AppConfiguration;
import com.example.demo.entities.structure.Laboratory;
import com.example.demo.services.equipment.EquipmentApiService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GeoCoordinateService {

  AppConfiguration appConfiguration;
  public List<Double> findGeoCoordinate(String city) throws IOException, InterruptedException {
      List<Double> coordinates = new ArrayList<>();
      String API_ENDPOINT = "https://nominatim.openstreetmap.org/search?format=json&q=" + city;
      HttpRequest request = HttpRequest.newBuilder()
              .GET()
              .header("accept", "application/json")
              .uri(URI.create(API_ENDPOINT))
              .build();
      HttpClient client = HttpClient.newHttpClient();
      HttpResponse<String> post = client.send(request, HttpResponse.BodyHandlers.ofString());
      ObjectMapper mapper = appConfiguration.objectMapper();
      JsonNode json = mapper.readTree(post.body());
      if (json.isArray() && json.size() > 0) {
          JsonNode firstResult = json.get(0);
          Double latitude = Double.parseDouble(firstResult.get("lat").asText());
          Double longitude = Double.parseDouble(firstResult.get("lon").asText());
          coordinates.add(latitude);
          coordinates.add(longitude);
      }
      return coordinates;
  }

  public Map<Laboratory,Double> getDistance(String city, List<Laboratory> laboratories, Double searchRadius) throws IOException, InterruptedException {
      List<Double> geoCoordinate = findGeoCoordinate(city);
      double lat1 = Math.toRadians(geoCoordinate.get(0));
      double lon1 = Math.toRadians(geoCoordinate.get(1));
      Map<Laboratory, Double> map = new HashMap<>();
      for (Laboratory l : laboratories) {
          double lat2 = Math.toRadians(l.getLatitude());
          double lon2 = Math.toRadians(l.getLongitude());
          double earthRadius = 6371.0;
          double dlon = lon2 - lon1;
          double dlat = lat2 - lat1;
          double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
          double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
          double radius = earthRadius * c;
          if (searchRadius > radius) {
              map.put(l, radius);
          }
      }
      return map;
  }
}
