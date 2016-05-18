package nikita.coursework.handler;

import nikita.coursework.composite.GVEShape;
import nikita.coursework.widget.GVEDrawingPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class EditState extends AbstractState {
//
    private List <GVEShape> group;
    private List <GVEShape> copy;

    private int x, y;
    private int x0, y0;
    private int xf, yf;
    private boolean frameCreation = false;
    private boolean dragging = false;


    public EditState(GVEDrawingPanel panel, JPanel inspector){
        super(panel, inspector);
        this.group = panel.getGroup();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        GVEShape gs = panel.selectElement(e.getX(), e.getY());
        if (gs != null) {
            if (e.isControlDown()) {
                group.add(gs);
            } else if (e.isAltDown()) {
                group.remove(gs);
            } else {
                group.clear();
                group.add(gs);
            }
        } else {
            if (!e.isAltDown() && !e.isControlDown()) {
                group.clear();
            }
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            copy.clear();
            copy.addAll(group);

            x0 = x = e.getX();
            y0 = y = e.getY();
            dragging = true;
        } else if (e.getButton() == MouseEvent.BUTTON1) {
            xf = e.getX();
            yf = e.getY();
            frameCreation = true;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (dragging) {
            for(GVEShape shape: copy)
                shape.setCords(e.getX() - x, e.getY() - y);
            panel.repaint();

            x = e.getX();
            y = e.getY();
        } else if (frameCreation) {
            int minX = Math.min(e.getX(), xf);
            int minY = Math.min(e.getY(), yf);
            int maxX = minX ^ e.getX() ^ xf;
            int maxY = minY ^ e.getY() ^ yf;


            panel.setFrame(minX, minY, maxX - minX, maxY - minY);
        }
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        if (dragging) {
            panel.setTempShape(null);
            panel.getPicture().setCords(x - x0, y - y0);
            dragging = false;
            copy = null;
        } else if (frameCreation) {
            panel.createGroup();
            panel.setFrame(xf, yf, 0, 0);
            frameCreation = false;
        }
    }

    @Override
    protected void setInnerElements(JPanel inspector) {

    }


}
