package com.javalab.designpattern.obsever;

public interface Observable {

    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyAllObserver();

}
