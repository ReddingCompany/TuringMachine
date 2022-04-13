package it.rrcompany.turingmachine.GUI;

import it.rrcompany.turingmachine.GUI.Code.CodePanel;
import it.rrcompany.turingmachine.GUI.Input.InputField;
import it.rrcompany.turingmachine.GUI.Input.InputPanel;
import it.rrcompany.turingmachine.GUI.Output.OutputPanel;
import it.rrcompany.turingmachine.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashMap;

public class MainFrame {

    public static final String TITLE = "Turing Machine";
    public static final JFrame mainFrame = new JFrame(TITLE);
    private static final HashMap<String, JComponent> components = new HashMap<>();

    private static final float MIN_WIDTH_SCALE = (float) 0.5;
    private static final float MIN_HEIGHT_SCALE = (float) 0.5;

    public MainFrame() {
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.setLocation((getDefaultWidth()*10/100), (int)(getDefaultHeight()*12.5/100));
        mainFrame.setSize(getDefaultWidth(), getDefaultHeight());
        mainFrame.setMinimumSize(new Dimension((int)(Utils.getScreenWidth()*MIN_WIDTH_SCALE), (int)(Utils.getScreenHeight()*MIN_HEIGHT_SCALE)));

        mainFrame.setVisible(true);
        mainFrame.setFocusable(true);
        mainFrame.setLayout(null);

        this.loadComponents();
    }

    public static int getDefaultWidth() {
        return Utils.getScreenWidth()-(Utils.getScreenWidth()*20/100);
    }

    public static int getDefaultHeight() {
        return Utils.getScreenHeight()-(Utils.getScreenHeight()*20/100);
    }

    public static void close() {
        mainFrame.dispose();
    }

    public static JComponent getComponent(String name) {
        return components.get(name.toUpperCase());
    }


    private void loadComponents() {
        CodePanel codePanel = new CodePanel(mainFrame);
        components.put("CODE_PANEL", codePanel);
        InputPanel inputPanel = new InputPanel(mainFrame);
        components.put("INPUT_PANEL", inputPanel);
        OutputPanel outputPanel = new OutputPanel(mainFrame);
        components.put("OUTPUT_PANEL", outputPanel);
        InputField inputField = new InputField(inputPanel);
        components.put("INPUT_FIELD", inputField);

        mainFrame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                for (JComponent component : components.values())
                    if (component instanceof CodePanel)
                        ((CodePanel) component).resize();
                    else if (component instanceof InputPanel)
                        ((InputPanel) component).resize();
                    else if (component instanceof OutputPanel)
                        ((OutputPanel) component).resize();
                    else if (component instanceof InputField)
                        ((InputField) component).resize();
            }
        });

    }



}
