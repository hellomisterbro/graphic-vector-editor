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
        System.out.println("LOL");
        List<GVEShape> group = panel.getGroup();
            for (GVEShape shape : group) {
                if (panel.getPicture().contains(shape)) {
                    panel.getPicture().remove(shape);
                }
            }
            if (group.contains(panel.getTempShape()))
                panel.setTempShape(null);
            for (GVEShape g : group)
                g.removeFrame();
            group.clear();
            panel.repaint();

        super.actionPerformed(e);
    }
}
