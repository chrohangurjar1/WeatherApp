package com.example.weatherapp.controller;

import com.example.weatherapp.model.WeatherData;
import com.example.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/")
    public String home() {
        return "weather";
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city, Model model) {
        WeatherData weatherData = weatherService.getWeatherData(city);
        model.addAttribute("weather", weatherData);
        model.addAttribute("city", city);
        return "weather";
    }
}
