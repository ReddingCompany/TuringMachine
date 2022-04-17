package it.rrcompany.turingmachine.material;

import it.rrcompany.turingmachine.GUI.MainFrame;
import it.rrcompany.turingmachine.GUI.Output.StateViewer;
import it.rrcompany.turingmachine.GUI.Output.TapeCell;
import it.rrcompany.turingmachine.TuringMachine;

import java.util.ArrayList;
import java.util.HashMap;

public class Tape {

    private long index = 0;
    private String state;
    private ArrayList<String> states;
    private HashMap<Long, Character> tape;
    private float speed;

    public Tape(long index, String state, ArrayList<String> states, HashMap<Long, Character> tape, float speed) {
        this.index = index;
        this.state = state;
        this.states = states;
        this.tape = tape;
        this.speed = speed;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public HashMap<Long, Character> getTape() {
        return tape;
    }

    public void setTape(HashMap<Long, Character> tape) {
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

    public Character getTapeResult(long index) {
        if (!this.tape.containsKey(index))
            this.tape.put(index, null);
        return this.tape.get(index);
    }

    public void setTapeResult(long index, Character c) {
        if (!this.tape.containsKey(index))
            this.tape.put(index, c);
        else this.tape.replace(index, c);
    }

    public void shift() {
        for (int i = 0; i<32; i++) {
            Character c = getTapeResult(i+this.index - (TuringMachine.startCell));
            ((TapeCell) MainFrame.getComponent("TAPE_CELL_" + i)).setText(c != null ? c.toString() : "");
        }
    }

    public void moveRight() {
        this.index++;
    }

    public void moveLeft() {
        this.index--;
    }

    public long speedConverter() {
        return this.speed == 10 ? 50 : this.speed == 9 ? 100 : this.speed == 8 ? 200
                        : this.speed == 7 ? 450  : this.speed == 6 ? 800  : this.speed == 5 ? 1000
                        : this.speed == 4 ? 2000 : this.speed == 3 ? 3500 : this.speed == 2 ? 5000
                        : this.speed == 1 ? 7500 : 1000000000;
    }
}
