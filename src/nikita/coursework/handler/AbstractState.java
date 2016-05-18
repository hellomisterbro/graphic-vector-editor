package nikita.coursework.handler;

import nikita.coursework.GVEFrame;
import nikita.coursework.composite.GVEShape;
import nikita.coursework.widget.GVEDrawingPanel;

import javax.swing.*;
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

    protected AbstractState(GVEDrawingPanel panel, JPanel inspector) {
        this.panel = panel;
        setEmptyPanel(inspector);
        setInnerElements(inspector);
        inspector.updateUI();
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

    protected void setEmptyPanel(JPanel inspector){
        inspector.removeAll();
        inspector.setBackground(GVEFrame.BAR_COLOR);
        inspector.setLayout(new BoxLayout(inspector, BoxLayout.PAGE_AXIS));
        inspector.setPreferredSize(new Dimension(200, GVEFrame.MIN_FRAME_HEIGHT));
        inspector.setBorder(BorderFactory.createLineBorder(GVEFrame.BORDER_COLOR));
    }

    protected abstract void setInnerElements(JPanel inspector);

}
