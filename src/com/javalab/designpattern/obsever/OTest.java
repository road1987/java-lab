package com.javalab.designpattern.obsever;

public class OTest {

    public static void main(String[] args) {
        OWeatherStation weatherStation = new OWeatherStation();
        OPhoneDisplay phoneDisplay = new OPhoneDisplay();
        OScreenDisplay screenDisplay = new OScreenDisplay();
        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(screenDisplay);
        weatherStation.setWeather("Rainy");
    }

}
