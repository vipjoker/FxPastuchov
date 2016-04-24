package sample.utils;

import sample.Main;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Admin on 24.04.2016.
 */
public class WindowUtils {

    public static void openFile(File file) {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(WindowUtils.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
