package nikita.coursework.handler;

import nikita.coursework.composite.GVEShape;
import nikita.coursework.widget.GVEDrawingPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
abstract public class AbstractState extends MouseAdapter {
    protected GVEDrawingPanel panel;

    protected Integer mousePressedX, mousePressedY;

    protected AbstractState(GVEDrawingPanel panel) {
        this.panel = panel;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        this.mousePressedX = e.getX();
        this.mousePressedY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        GVEShape shape = this.panel.getTempShape();
        if (shape != null) {
            shape.setCords((e.getX() > mousePressedX) ? mousePressedX : e.getX(),
                           (e.getY() > mousePressedY) ? mousePressedY : e.getY());
            shape.setSize(Math.abs(e.getX() - mousePressedX),
                          Math.abs(e.getY() - mousePressedY));
            this.panel.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        mousePressedX = null;
        mousePressedY = null;
        this.panel.addTempShape();
    }
}
