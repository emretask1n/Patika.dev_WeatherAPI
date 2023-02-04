package com.emretaskin.weatherapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class Forecast {
    private ArrayList<ForecastDay> forecastDays;
}
