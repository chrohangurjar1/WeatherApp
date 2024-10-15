package com.example.weatherapp.service;

import com.example.weatherapp.model.WeatherData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    
    private final String API_KEY = "xxxxxxxxxx";
    private final String WEATHER_API_URL = "https://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}&units=metric";

    public WeatherData getWeatherData(String city) {
        RestTemplate restTemplate = new RestTemplate();
        WeatherData weatherData = restTemplate.getForObject(WEATHER_API_URL, WeatherData.class, city, API_KEY);
        return weatherData;
    }
}
