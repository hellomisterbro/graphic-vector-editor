package nikita.coursework.handler;

import nikita.coursework.composite.GVERectangle;
import nikita.coursework.composite.GVEShape;
import nikita.coursework.widget.GVEDrawingPanel;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class RectangleState extends AbstractState  {

    public RectangleState(GVEDrawingPanel panel){
        super(panel);
    }


    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        GVERectangle rect = new GVERectangle(e.getX(), e.getY(), 0, 0);
        this.panel.setTempShape(rect);
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }
}
