package com.javalab.designpattern.state;

public class OpenState implements GateState {

    private Gate gate;

    public OpenState(Gate gate) {
        this.gate = gate;
    }

    @Override
    public void enter() {
        this.gate.changeState(new CloseState(this.gate));
        System.out.println("Action pay : open -----> close");
    }

    @Override
    public void pay() {
        System.out.println("current state is open , keep open state");
    }

    @Override
    public void payOk() {
        System.out.println("Action payOK :  do nothing in open state");
    }

    @Override
    public void payFailed() {
        System.out.println("Action payFailed :  do nothing in open state");
    }

    @Override
    public String toString() {
        return "Open";
    }
}
