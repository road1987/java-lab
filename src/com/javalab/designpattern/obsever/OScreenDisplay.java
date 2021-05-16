package com.javalab.designpattern.obsever;

import java.util.Observable;
import java.util.Observer;

public class OScreenDisplay implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Screen diaplay: " + ((OWeatherStation) o).getWeather());
    }

}
