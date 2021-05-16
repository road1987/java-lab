package com.javalab.designpattern.state;

public class CloseState implements GateState {

    private Gate gate;

    public CloseState(Gate gate) {
        this.gate = gate;
    }

    @Override
    public void enter() {
        System.out.println("Can't enter in close state");
    }

    @Override
    public void pay() {
        GateState state = new ProcessState(this.gate);
        this.gate.changeState(state);
        System.out.println("Action pay : close -----> process");
    }

    @Override
    public void payOk() {
        System.out.println("Action PayOk : do nothing in close state");
    }

    @Override
    public void payFailed() {
        System.out.println("Action PayFailed :  PayFailed do nothing in close state");
    }

    @Override
    public String toString() {
        return "Close";
    }

}
