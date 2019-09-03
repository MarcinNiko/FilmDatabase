package com.omdb.webapp.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.omdb.webapp.model.Film;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class OmdbService {
    static private String charset = "UTF-8";
    private static final String url = "http://www.omdbapi.com/?apikey=81c13a05&";
    private static URLConnection connection;

    public static Film handleOmdb(String title) {
        Film film = new Film();
        try {
        sendGetRequest(title);
        readOmdbResponse(film);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return film;
    }

    public static void sendGetRequest(String title) throws IOException {
        System.out.println("Enter title: ");

        String query = String.format("t=%s", URLEncoder.encode(title,charset));

        connection = new URL(url + query).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);

    }

    public static Film readOmdbResponse(Film film){
        try {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer response = new StringBuffer();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine + "\n");
        }
        in.close();
        proceedResponse(film, response.toString());
        System.out.println(response.toString());
        System.out.println(film);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return film;
    }

    public static Film proceedResponse(Film film, String response) throws JSONException {
        JSONObject jsonObject = new JSONObject(response);
        film.setTitle(jsonObject.getString("Title"));
        film.setDirector(jsonObject.getString("Director"));
        film.setYear(jsonObject.getString("Released"));
        film.setRate(jsonObject.getString("Rated"));
        film.setActors(jsonObject.getString("Actors"));
        return film;
    }
}
