package it.rrcompany.turingmachine.material;

import java.util.ArrayList;

public class Tape {

    private int index = 0;
    private String state;
    private ArrayList<String> states;
    private ArrayList<Character> tape;
    private float speed;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<Character> getTape() {
        return tape;
    }

    public void setTape(ArrayList<Character> tape) {
        this.tape = tape;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ArrayList<String> getStates() {
        return states;
    }

    public void setStates(ArrayList<String> states) {
        this.states = states;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
