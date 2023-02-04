package com.emretaskin.weatherapi.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;

@Setter
@Getter
public class ForecastDay {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;
    private int date_epoch;
    private Day day;
    private Astro astro;
    private ArrayList<Hour> hour;
}
