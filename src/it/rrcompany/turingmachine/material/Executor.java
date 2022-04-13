package it.rrcompany.turingmachine.material;

import java.util.ArrayList;

public class Executor extends Tape implements Interpreter {

    private ArrayList<String> input;
    private String[]
        inputState,
        inputChar,
        outputState,
        outputChar,
        pointer;

    private void load() {

        for (String instruction : input) {

            if (!(instruction.charAt(0) == '(' && instruction.charAt(instruction.length()) == ')')) {
                System.out.println("Errore parentesi mancanti in: " + instruction);
                return;
            }

            instruction = instruction.substring(0, instruction.length()-1).substring(0,1);

            //REGEX \ con ,

        }

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
}
