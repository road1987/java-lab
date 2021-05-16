package com.javalab.designpattern.state;

public class ProcessState implements GateState {

    private Gate gate;

    public ProcessState(Gate gate) {
        this.gate = gate;
    }

    @Override
    public void enter() {
        System.out.println("Action Enter :  do nothing in process state");
    }

    @Override
    public void pay() {
        System.out.println("Action pay :  do nothing in process state");
    }

    @Override
    public void payOk() {
        this.gate.changeState(new OpenState(gate));
        System.out.println("Action payOk : process -----> open");
    }

    @Override
    public void payFailed() {
        this.gate.changeState(new CloseState(gate));
        System.out.println("Action payFailed : process -----> close");
    }

    @Override
    public String toString() {
        return "Processing";
    }

}
