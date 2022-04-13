package it.rrcompany.turingmachine.GUI.Code;

import it.rrcompany.turingmachine.GUI.MainFrame;
import it.rrcompany.turingmachine.GUI.TuringComponent;

import javax.swing.*;
import java.awt.*;

public class CodePanel extends JPanel implements TuringComponent {

    private static final JFrame parentFrame = MainFrame.mainFrame;
    public final static float scaleWidth = (float) 0.3;

    public CodePanel() {

        this.resize();

        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.RED);

        parentFrame.getContentPane().add(this);
        this.setVisible(true);
    }

    @Override
    public void resize() {
        this.setLocation(this.getPosX(), this.getPosY());
        this.setSize(this.getWidth(), this.getHeight());

    }

    public int getPosX() {
        return (int)(parentFrame.getWidth()*(1-scaleWidth));
    }

    public int getPosY() {
        return 0;
    }

    public int getWidth() {
        return (int)(parentFrame.getWidth()*(scaleWidth));
    }

    public int getHeight() {
        return parentFrame.getHeight();
    }

}
