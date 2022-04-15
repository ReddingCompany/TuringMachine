package it.rrcompany.turingmachine.material;

import it.rrcompany.turingmachine.GUI.MainFrame;
import it.rrcompany.turingmachine.GUI.Output.TapeCell;
import it.rrcompany.turingmachine.TuringMachine;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Executor extends Tape implements Interpreter, Runnable {

    private ArrayList<String> input;
    private String[]
        inputState,
        inputChar,
        outputState,
        outputChar,
        pointer;
    private boolean started;

    public Executor(long index, String state, ArrayList<String> states, HashMap<Long, Character> tape, float speed) {
        super(index, state, states, tape, speed);
    }

    public void start(String str) {
        for (int i = 0; i<str.length(); i++)
            this.getTape().put((long)i, str.charAt(i));
        this.shift();
    }

    public ArrayList<String> getInput() {
        return input;
    }
    public void setInput(ArrayList<String> input) {
        this.input = input;
    }
    public String[] getInputState() {
        return inputState;
    }
    public void setInputState(String[] inputState) {
        this.inputState = inputState;
    }
    public String[] getInputChar() {
        return inputChar;
    }
    public void setInputChar(String[] inputChar) {
        this.inputChar = inputChar;
    }
    public String[] getOutputState() {
        return outputState;
    }
    public void setOutputState(String[] outputState) {
        this.outputState = outputState;
    }
    public String[] getOutputChar() {
        return outputChar;
    }
    public void setOutputChar(String[] outputChar) {
        this.outputChar = outputChar;
    }
    public String[] getPointer() {
        return pointer;
    }
    public void setPointer(String[] pointer) {
        this.pointer = pointer;
    }
    public boolean isStarted() {
        return started;
    }
    public void setStarted(boolean started) {
        this.started = started;
    }

    @Override
    public void run() {
        while(true) {
            if (!this.started) {
                this.setIndex(0);
                break;
            }

            try {
                Thread.sleep(this.speedConverter()/2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            TapeCell indexCell = (TapeCell) MainFrame.getComponent("TAPE_CELL_"+TuringMachine.startCell);
            indexCell.getBackgroundPanel().setBorder(BorderFactory.createLineBorder(Color.RED));
            try {
                Thread.sleep(this.speedConverter()/2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            indexCell.getBackgroundPanel().setBorder(BorderFactory.createLineBorder(Color.BLACK));

            this.moveRight();
            this.shift();
        }
    }
}
