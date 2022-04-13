package it.rrcompany.turingmachine.GUI.Code;

import it.rrcompany.turingmachine.GUI.MainFrame;

import javax.swing.*;
import java.awt.*;

public class CodePanel extends JPanel {

    private static JFrame parentFrame;
    public final static float scaleWidth = (float) 0.3;

    public CodePanel(JFrame parentFrame) {
        CodePanel.parentFrame = parentFrame;

        this.setLocation(((int)(MainFrame.getDefaultWidth()*(1-scaleWidth))), 0);
        this.setSize((int)(parentFrame.getWidth()*(scaleWidth)), parentFrame.getHeight());
        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.RED);

        parentFrame.getContentPane().add(this);
        this.setVisible(true);
    }

    public void resize() {
        this.setLocation(((int)(parentFrame.getWidth()*(1-scaleWidth))), 0);
        this.setSize((int)(parentFrame.getWidth()*(scaleWidth)), parentFrame.getHeight());
    }

}
