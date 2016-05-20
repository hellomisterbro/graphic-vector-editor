package nikita.coursework.command;

import nikita.coursework.composite.GVEShape;
import nikita.coursework.widget.GVEDrawingPanel;

import java.awt.event.ActionEvent;

public class MoveCommand extends AbstractCommand {

    private GVEShape shape;

    private int dx, dy;

    public MoveCommand(GVEDrawingPanel panel, GVEShape shape) {
        super(panel);
        this.shape = shape;
    }

    public void setDelta(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        shape.setCords(dx, dy);
        super.actionPerformed(e);
    }
}
