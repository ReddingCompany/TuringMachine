package it.rrcompany.turingmachine.GUI.Input;

import it.rrcompany.turingmachine.GUI.Code.CodePanel;
import it.rrcompany.turingmachine.GUI.MainFrame;
import it.rrcompany.turingmachine.GUI.TuringComponent;

import javax.swing.*;
import java.awt.*;
import java.time.temporal.TemporalUnit;

public class InputPanel extends JPanel implements TuringComponent {

    private static final JFrame parentFrame = MainFrame.mainFrame;
    public final static float scaleHeight = (float) 0.4;

    public InputPanel() {

        this.resize();

        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.GREEN);

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
        return (int)(parentFrame.getHeight()*(1-scaleHeight));
    }

    public int getWidth() {
        return parentFrame.getWidth()-((int)(parentFrame.getWidth()*CodePanel.scaleWidth));
    }

    public int getHeight() {
        return (int)(parentFrame.getHeight()*(scaleHeight));
    }


}
