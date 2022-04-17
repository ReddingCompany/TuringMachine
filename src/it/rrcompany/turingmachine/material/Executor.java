package it.rrcompany.turingmachine.material;

import it.rrcompany.turingmachine.GUI.Code.CodeArea;
import it.rrcompany.turingmachine.GUI.MainFrame;
import it.rrcompany.turingmachine.GUI.Output.StateViewer;
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
                return;
            }

            try {
                Thread.sleep(this.speedConverter()/2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            TapeCell indexCell = (TapeCell) MainFrame.getComponent("TAPE_CELL_"+TuringMachine.startCell);
            indexCell.setForeground(Color.RED);
            indexCell.setFont(indexCell.getFont().deriveFont(Font.BOLD));
            try {
                Thread.sleep(this.speedConverter()/2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            indexCell.setFont(indexCell.getFont().deriveFont(Font.PLAIN));
            indexCell.setForeground(Color.BLACK);

            if (!read(readIstructions(), indexCell.getText())) {
                setStarted(false);
                this.setIndex(0);
                return;
            }
        }
    }

    public String[] readIstructions() {
        CodeArea code = (CodeArea) MainFrame.getComponent("CODE_AREA");
        return code.getText().split("\\r?\\n");
    }

    public boolean read(String[] istr, String input) {
        for (String i : istr) {
            if (i.length()<=1 || i.charAt(0) == '#')
                continue;
            String[] x = i.substring(1, i.length()-1).replaceAll(" ", "").split(",");

            input = input.equalsIgnoreCase("") ? "-" : input;

            if (x[1].contains("^") && x[0].equalsIgnoreCase(this.getState())) {

                x[1] = x[1].replaceAll("\\^", "");

                if (x[1].length()>0 && input.equalsIgnoreCase(x[1]))
                    continue;

                this.setState(x[2]);
                ((StateViewer)MainFrame.getComponent("STATE_VIEWER")).setText(this.getState());
                MainFrame.getComponent("STATE_VIEWER").resize();

                if (!x[3].contains("^"))
                    this.setTapeResult(this.getIndex(), x[3].equalsIgnoreCase("-") ? null : x[3].charAt(0));
                this.shift();

                if (x[4].equalsIgnoreCase(">"))
                    this.moveRight();
                else if (x[4].equalsIgnoreCase("<"))
                    this.moveLeft();

                this.shift();

                return true;

            } else if (x[0].equalsIgnoreCase(this.getState()) && input.equalsIgnoreCase(x[1])) {
                this.setState(x[2]);
                ((StateViewer)MainFrame.getComponent("STATE_VIEWER")).setText(this.getState());
                MainFrame.getComponent("STATE_VIEWER").resize();

                this.setTapeResult(this.getIndex(), x[3].equalsIgnoreCase("-") ? null : x[3].charAt(0));
                this.shift();

                if (x[4].equalsIgnoreCase(">"))
                    this.moveRight();
                else if (x[4].equalsIgnoreCase("<"))
                    this.moveLeft();

                this.shift();

                return true;
            }
        }
        return false;
    }
}
