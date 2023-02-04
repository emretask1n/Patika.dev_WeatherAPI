package com.emretaskin.weatherapi.service;

import com.emretaskin.weatherapi.model.WeatherApiRoot;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@Service
public class WeatherApiService {
    private static final String weatherApiForecastUrl = "http://api.weatherapi.com/v1/forecast.json?key=";
    private static final String weatherApiHistoryUrl = "http://api.weatherapi.com/v1/history.json?key=";
    private final Logger logger = LoggerFactory.getLogger(WeatherApiService.class);
    private final RestTemplate restTemplate;
    private final String weatherApiKey = "152c74d996b34016926101444230402";

    public WeatherApiRoot getWeatherForecast(String cityName, Integer day) {
        logger.info("Requesting api.weatherapi.com {} days weather for {}", day, cityName);

        return restTemplate.getForObject(weatherApiForecastUrl + weatherApiKey +
                        "&q=" + cityName + "&days=" + day + "&aqi=no&alerts=no",
                WeatherApiRoot.class);
    }

    public WeatherApiRoot getWeatherHistory(String cityName, String dt) {
        logger.info("Requesting api.weatherapi.com {} date weather for {}", dt, cityName);

        return restTemplate.getForObject(weatherApiHistoryUrl + weatherApiKey +
                        "&q=" + cityName + "&dt=" + dt + "&aqi=no&alerts=no",
                WeatherApiRoot.class);
    }

}
