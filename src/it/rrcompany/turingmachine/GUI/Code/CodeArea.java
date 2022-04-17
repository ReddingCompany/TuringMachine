package it.rrcompany.turingmachine.GUI.Code;

import it.rrcompany.turingmachine.GUI.MainFrame;
import it.rrcompany.turingmachine.GUI.Output.OutputPanel;
import it.rrcompany.turingmachine.GUI.Output.StateViewer;
import it.rrcompany.turingmachine.GUI.TuringComponent;

import javax.swing.*;
import java.awt.*;

public class CodeArea extends JTextArea implements TuringComponent {

    private static CodePanel parentPanel;
    public final static float locHeight = (float) 0.02;

    private JScrollPane scrollBar;

    public CodeArea(CodePanel parentPanel) {
        CodeArea.parentPanel = parentPanel;

        this.setFocusable(true);

        JScrollPane scrollBar = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        this.scrollBar = scrollBar;
        this.setAutoscrolls(true);

        this.scrollBar.add(this);
        this.scrollBar.setViewportView(this);

        parentPanel.add(scrollBar);
        this.setVisible(true);
        this.setRows(1000);
        this.setColumns(1000);

        this.resize();
    }

    @Override
    public void resize() {
        this.setFont(new java.awt.Font("Verdana", Font.PLAIN, 14+(MainFrame.mainFrame.getHeight()-400)/100));

        this.setLocation(this.getPosX(), this.getPosY());
        this.setSize(this.getWidth(), this.getHeight());
        scrollBar.setLocation(this.getPosX(), this.getPosY());
        scrollBar.setSize(this.getWidth(), this.getHeight());

    }

    public int getPosX() {
        return (int)(parentPanel.getWidth()*(1.8*locHeight));
    }

    public int getPosY() {
        return (int)(parentPanel.getHeight()*(locHeight));
    }

    public int getWidth() {
        return (int)(parentPanel.getWidth()-3*getPosX());
    }

    public int getHeight() {
        return (int)(parentPanel.getHeight()-4*getPosY());
    }

    public JScrollPane getScrollBar() {
        return scrollBar;
    }

    public void setScrollBar(JScrollPane scrollBar) {
        this.scrollBar = scrollBar;
    }
}
