package com.example.demo.services.equipment;

import com.example.demo.entities.equipment.type.Equipment;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.net.URI;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EquipmentApiService {
  @SneakyThrows
  public List<Equipment> api(String mitNumber, String number) {
    String postApiUri = "https://fgis.gost.ru/fundmetrology/cm/xcdb/vri/select?fq=mi.mitnumber:" + mitNumber
            + "&fq=mi.number:" + number + "&q=*&fl=vri_id,org_title,mi.mitnumber,mi.modification,mi.number,verification_date,valid_date,applicability&sort=verification_date+desc,org_title+asc&rows=15&start=0";
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(postApiUri))
                .build();
    HttpResponse<String> response = client.
            send(request, HttpResponse.BodyHandlers.ofString());
    ObjectMapper mapper = objectMapper();
    JsonNode json = mapper.readTree(response.body());
    JsonNode docsArray = json.get("response").get("docs");
    CollectionLikeType postCollection = mapper.getTypeFactory()
            .constructCollectionLikeType(ArrayList.class, Equipment.class);
    return mapper.convertValue(docsArray, postCollection);
  }

  public ObjectMapper objectMapper() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
    mapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    mapper.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
    return mapper;
  }
}
