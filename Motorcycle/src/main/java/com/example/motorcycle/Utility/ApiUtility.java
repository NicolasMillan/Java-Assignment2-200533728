package com.example.motorcycle.Utility;

import com.example.motorcycle.Models.Motorcycle;
import com.example.motorcycle.Models.MotorcycleDetails;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ApiUtility {
    public static Motorcycle[] getDataFromAPIQuickList(String searchMake, String searchModel) {

        // Delete the space in the text field
        searchMake = searchMake.replaceAll(" ", "-");
        searchModel = searchModel.replaceAll(" ", "");

        String uri = "https://api.api-ninjas.com/v1/motorcycles?make=" + searchMake + "&model=" + searchModel;
        String apiKey = "lMZ1I4U6ZcR7YHtFfhZGHLKJlDXNMfXuHlUc3CKe";

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("X-Api-Key", apiKey)
                .build();
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();

            return gson.fromJson(response.body(), Motorcycle[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MotorcycleDetails[] getMotorcycleDetailsFromAPIQuickList(String searchMake, String searchModel) {

        // Delete the space in the text field
        searchMake = searchMake.replaceAll(" ", "-");
        searchModel = searchModel.replaceAll(" ", "");

        String uri = "https://api.api-ninjas.com/v1/motorcycles?make=" + searchMake + "&model=" + searchModel;
        String apiKey = "lMZ1I4U6ZcR7YHtFfhZGHLKJlDXNMfXuHlUc3CKe";

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("X-Api-Key", apiKey)
                .build();
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();

            return gson.fromJson(response.body(), MotorcycleDetails[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}