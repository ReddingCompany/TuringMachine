package it.rrcompany.turingmachine;

import it.rrcompany.turingmachine.GUI.MainFrame;
import it.rrcompany.turingmachine.material.Executor;

import java.util.ArrayList;
import java.util.HashMap;

public class TuringMachine {

    public static MainFrame frame;
    public static Executor executor = new Executor(0, "0", new ArrayList<>(), new HashMap<>(), 5);
    public static int startCell = 16;

    public static void main(String[] args) {
        frame = new MainFrame();
    }

}
