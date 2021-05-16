package com.javalab.designpattern.state;

public interface GateState {

    void enter();

    void pay();

    void payOk();

    void payFailed();
}
