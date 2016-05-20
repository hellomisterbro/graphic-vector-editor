package nikita.coursework.command.graph;


import nikita.coursework.command.AbstractCommand;
import nikita.coursework.composite.GVEShape;
import nikita.coursework.widget.GVEDrawingPanel;

import java.awt.event.ActionEvent;
import java.util.List;


public class DeleteCommand extends AbstractCommand {

    public DeleteCommand(GVEDrawingPanel panel) {
        super(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<GVEShape> group = panel.getGroup();
        for (GVEShape element : group) {
            panel.getPicture().remove(element);
        }
        group.clear();

        super.actionPerformed(e);
    }
}
