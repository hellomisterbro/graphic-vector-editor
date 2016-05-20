package nikita.coursework;

import javax.swing.*;
import java.awt.*;

public class GraphicVectorEditor {

    public static void main(String[] args) throws Exception {

//        GVEShape shape0 = new GVERectangle(4, 5, 3, 6);
//        GVEShape shape1 = new GVERectangle(4, 4, 3, 1);;
//
//        ObjectOutputStream stream = new ObjectOutputStream(
//                new FileOutputStream(new File("o.ser"))
//        );
//
//        ObjectInputStream iStream = new ObjectInputStream(
//                new FileInputStream(new File("o.ser"))
//        );
//
//        GVEComposite composite = new GVEComposite();
//
//        composite.add(shape0);
//        composite.add(shape1);
//
//        stream.writeObject(composite);
//
//        GVEShape deserialized = (GVEShape) iStream.readObject();
//
//        System.out.println(deserialized);


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
