package com.emretaskin.weatherapi.controller;

import com.emretaskin.weatherapi.model.WeatherApiRoot;
import com.emretaskin.weatherapi.service.WeatherApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("api/weather")
public class WeatherApiController {

    private final WeatherApiService weatherApiService;

    @GetMapping("/{cityName}/{day}")
    public ResponseEntity<WeatherApiRoot> getWeatherByCityNameAndParameter(@PathVariable String cityName, @PathVariable Integer day) {
        if (day == null) {
            throw new NullPointerException();
        }
        if (day < 0 || day > 14) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(weatherApiService.getWeatherForecast(cityName, day));
    }

    @GetMapping("/history/{cityName}/{date}")
    public ResponseEntity<WeatherApiRoot> getWeatherHistory(@PathVariable String cityName, @PathVariable String dt) {
        return ResponseEntity.ok(weatherApiService.getWeatherHistory(cityName, dt));

    }


}
