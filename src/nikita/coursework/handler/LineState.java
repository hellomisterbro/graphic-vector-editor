package nikita.coursework.handler;

import nikita.coursework.composite.GVELine;
import nikita.coursework.composite.GVEShape;
import nikita.coursework.widget.GVEDrawingPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class LineState extends AbstractState {

    public LineState(GVEDrawingPanel panel, JPanel inspector) {
        super(panel, inspector);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);

        GVELine oval = new GVELine(e.getX(), e.getY(), 0, 0);
        this.panel.setTempShape(oval);
    }
    @Override
    public void mouseDragged(MouseEvent e) {

        GVEShape shape = this.panel.getTempShape();
        if (shape != null && shape instanceof GVELine) {
            ((GVELine) shape).setCords(mousePressedX, mousePressedY, e.getX(), e.getY());
            this.panel.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }

    @Override
    protected void setInnerElements(JPanel inspector) {

    }
}
