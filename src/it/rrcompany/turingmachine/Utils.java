package it.rrcompany.turingmachine;

import java.awt.*;

public class Utils {

    private final static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static Dimension getScreenSize() {
        return screenSize;
    }

    public static int getScreenWidth() {
        return screenSize.width;
    }

    public static int getScreenHeight() {
        return screenSize.height;
    }

}
