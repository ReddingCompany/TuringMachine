package it.rrcompany.turingmachine.GUI.Input;

import it.rrcompany.turingmachine.GUI.Code.CodePanel;
import it.rrcompany.turingmachine.GUI.MainFrame;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {

    private static JFrame parentFrame;
    public final static float scaleHeight = (float) 0.4;

    public InputPanel(JFrame parentFrame) {
        InputPanel.parentFrame = parentFrame;

        this.setLocation(0, ((int)(MainFrame.getDefaultHeight()*(1-scaleHeight))));
        this.setSize(parentFrame.getWidth()-((int)(parentFrame.getWidth()* CodePanel.scaleWidth)), (int)(parentFrame.getHeight()*(scaleHeight)));
        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.GREEN);

        parentFrame.getContentPane().add(this);
        this.setVisible(true);
    }

    public void resize() {
        this.setLocation(0, ((int)(parentFrame.getHeight()*(1-scaleHeight))));
        this.setSize(parentFrame.getWidth()-((int)(parentFrame.getWidth()*CodePanel.scaleWidth)), (int)(parentFrame.getHeight()*(scaleHeight)));
    }


}
