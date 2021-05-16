package com.javalab.designpattern.obsever;

import java.util.Observable;
import java.util.Observer;

public class OPhoneDisplay implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Phone display: " + ((OWeatherStation) o).getWeather());
    }

}
