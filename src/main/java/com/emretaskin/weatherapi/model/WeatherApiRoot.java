package com.emretaskin.weatherapi.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WeatherApiRoot {
    private Location location;
    private Current current;
    private Forecast forecast;
}
