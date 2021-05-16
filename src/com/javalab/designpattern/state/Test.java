package com.javalab.designpattern.state;

public class Test {

    public static void main(String[] args) {
        Gate gate = new Gate();
        gate.payFailed();
        gate.enter();

        gate.pay();
        gate.payFailed();
        gate.pay();
        gate.payOk();
        gate.payFailed();
        gate.enter();
        gate.pay();
        gate.payFailed();
        System.out.println(gate.getState());
    }

}
