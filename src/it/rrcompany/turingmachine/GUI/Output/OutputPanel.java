package it.rrcompany.turingmachine.GUI.Output;

import it.rrcompany.turingmachine.GUI.Code.CodePanel;
import it.rrcompany.turingmachine.GUI.Input.InputPanel;
import it.rrcompany.turingmachine.GUI.MainFrame;
import it.rrcompany.turingmachine.GUI.TuringComponent;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel implements TuringComponent {

    private static final JFrame parentFrame = MainFrame.mainFrame;

    public OutputPanel() {

        this.resize();

        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.BLUE);

        parentFrame.getContentPane().add(this);
        this.setVisible(true);
    }

    @Override
    public void resize() {
        this.setLocation(this.getPosX(), this.getPosY());
        this.setSize(this.getWidth(), this.getHeight());
    }

    public int getPosX() {
        return 0;
    }

    public int getPosY() {
        return 0;
    }

    public int getWidth() {
        return parentFrame.getWidth()-((int)(parentFrame.getWidth()* CodePanel.scaleWidth));
    }

    public int getHeight() {
        return (int)(parentFrame.getHeight()*(1- InputPanel.scaleHeight));
    }


}
