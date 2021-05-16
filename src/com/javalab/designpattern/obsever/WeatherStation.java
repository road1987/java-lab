package com.javalab.designpattern.obsever;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Observable {

    String weather;
    List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);

    }

    @Override
    public void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void setWeather(String weather) {
        this.weather = weather;
        this.notifyAllObserver();
    }

    public String getWeather() {
        return weather;
    }

}
