package nikita.coursework.handler;

import nikita.coursework.composite.GVEOval;
import nikita.coursework.composite.GVERectangle;
import nikita.coursework.composite.GVEShape;
import nikita.coursework.widget.GVEDrawingPanel;

import java.awt.event.MouseEvent;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class OvalState extends AbstractState {
    
    public OvalState(GVEDrawingPanel panel){
        super(panel);
    }



    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        GVEOval oval = new GVEOval(e.getX(), e.getY(), 0, 0);
        this.panel.setTempShape(oval);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }
}
