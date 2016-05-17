package nikita.coursework.handler;

import nikita.coursework.composite.GVEBrush;
import nikita.coursework.widget.GVEDrawingPanel;

import java.awt.event.MouseEvent;

/**
 * Created by nikita on 17.05.16.
 */
public class BrushState extends AbstractState {

    public BrushState(GVEDrawingPanel panel) {
        super(panel);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        GVEBrush brush = new GVEBrush(e.getX(), e.getY(), 10);
        brush.add(e.getPoint());
        panel.setTempShape(brush);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        ((GVEBrush)panel.getTempShape()).add(e.getPoint());
        this.panel.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        panel.addTempShape();
    }
}
