package it.rrcompany.turingmachine.GUI;

import javax.swing.*;

public class MainFrame {

    public static final String TITLE = "Turing Machine";

    private static JFrame mainFrame = new JFrame(TITLE);

    public MainFrame() {
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setUndecorated(true);
        mainFrame.setSize(500, 300);
        mainFrame.setVisible(true);
    }

}
