package it.rrcompany.turingmachine.GUI.Input;

import it.rrcompany.turingmachine.GUI.MainFrame;
import it.rrcompany.turingmachine.GUI.TuringComponent;
import it.rrcompany.turingmachine.TuringMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

public class StartButton extends JButton implements TuringComponent {

    private static InputPanel parentPanel;
    public final static float scaleWidth = (float) 0.7/3;
    public final static float scaleHeight = (float) 0.09;

    public StartButton(InputPanel parentPanel) {
        StartButton.parentPanel = parentPanel;

        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.YELLOW);

        parentPanel.add(this);
        this.setVisible(true);

        this.setText("Start");

        this.resize();

        this.addActionListener(e -> {
            if (TuringMachine.executor.isStarted())
                return;

            TuringMachine.executor.start(((InputField)MainFrame.getComponent("INPUT_FIELD")).getText());
            new Thread(TuringMachine.executor).start();
            TuringMachine.executor.setStarted(true);
        });
    }

    @Override
    public void resize() {
        this.setFont(new java.awt.Font("Verdana", Font.PLAIN, 14+(MainFrame.mainFrame.getHeight()-400)/100));

        this.setLocation(this.getPosX(), this.getPosY());
        this.setSize(this.getWidth(), this.getHeight());
    }

    public int getPosX() {
        return (int)(parentPanel.getWidth()*((1-InputField.scaleWidth)/2));
    }

    public int getPosY() {
        return (int)(parentPanel.getHeight()*(InputField.locHeight+InputField.scaleHeight));
    }

    public int getWidth() {
        return (int)(parentPanel.getWidth()*(scaleWidth));
    }

    public int getHeight() {
        return (int)(parentPanel.getHeight()*(scaleHeight));
    }
}
