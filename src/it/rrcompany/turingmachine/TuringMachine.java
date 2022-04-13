package it.rrcompany.turingmachine;

import it.rrcompany.turingmachine.GUI.MainFrame;
import it.rrcompany.turingmachine.material.Executor;

public class TuringMachine {

    public static MainFrame frame;
    public static Executor executor = new Executor();

    public static void main(String[] args) {
        frame = new MainFrame();
    }

}
