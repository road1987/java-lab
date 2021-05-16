package com.javalab.designpattern.obsever;


public class ScreenDisplay implements Observer {

    private WeatherStation weatherStation;

    public ScreenDisplay(WeatherStation wStation) {
        this.weatherStation = wStation;
    }

    @Override
    public void update() {
        System.out.println("Screen diaplay: " + this.weatherStation.getWeather());
    }

}
