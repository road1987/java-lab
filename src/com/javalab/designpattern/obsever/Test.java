package com.javalab.designpattern.obsever;

public class Test {

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        ScreenDisplay screenDisplay = new ScreenDisplay(weatherStation);
        ScreenDisplay screenDisplay1 = new ScreenDisplay(weatherStation);
        weatherStation.addObserver(screenDisplay);
        weatherStation.addObserver(screenDisplay1);
        weatherStation.setWeather("Sunny");
    }

}
