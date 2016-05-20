package nikita.coursework.command.graph;

import nikita.coursework.command.AbstractCommand;
import nikita.coursework.composite.GVEShape;
import nikita.coursework.widget.GVEDrawingPanel;

import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class PasteCommand extends AbstractCommand {

    private static final int delta = 15;
    static ArrayList<GVEShape> buffer = new ArrayList<>();


    public PasteCommand(GVEDrawingPanel panel) {
        super(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print("PASTE");
        for (GVEShape element : buffer) {
            element.setCords(delta, delta);
            panel.getPicture().add(element);
        }
        buffer = (ArrayList<GVEShape>) buffer.clone();
        super.actionPerformed(e);
    }
}
