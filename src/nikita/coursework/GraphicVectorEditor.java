package nikita.coursework;

import javax.swing.*;
import java.awt.*;

/**
 * Created by nikita on 10.05.16.
 */
public class GraphicVectorEditor {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }


        EventQueue.invokeLater(() -> {
            GVEFrame ex = new GVEFrame();
            ex.setVisible(true);
        });
    }
}
