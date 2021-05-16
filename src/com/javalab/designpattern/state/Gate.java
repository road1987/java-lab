package com.javalab.designpattern.state;

public class Gate {

    private GateState state;

    public Gate() {
        this.state = new CloseState(this);
    }

    public void enter() {
        this.state.enter();
    }

    public void pay() {
        this.state.pay();
    }

    public void payOk() {
        this.state.payOk();
    }

    public void payFailed() {
        this.state.payFailed();
    }

    public void changeState(GateState state) {
        this.state = state;
    }

    public String getState() {
        return this.state.toString();
    }
}
