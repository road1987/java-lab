package com.javalab.designpattern.obsever;

import java.util.Observable;

public class OWeatherStation extends Observable {
    private String weather = "Sunny";

    public String getWeather() {
        return this.weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
        this.setChanged();
        this.notifyObservers();
    }
}
