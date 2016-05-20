package nikita.coursework.command.graph;

import nikita.coursework.command.AbstractCommand;
import nikita.coursework.composite.GVEShape;
import nikita.coursework.widget.GVEDrawingPanel;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import static nikita.coursework.command.graph.PasteCommand.buffer;


public class CopyCommand extends AbstractCommand {


    public CopyCommand(GVEDrawingPanel panel) {
        super(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buffer = (ArrayList<GVEShape>) panel.getGroup().clone();
    }

}
