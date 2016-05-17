package nikita.coursework.widget;


import nikita.coursework.composite.GVEComposite;
import nikita.coursework.composite.GVEShape;
import nikita.coursework.handler.AbstractState;
import nikita.coursework.memento.GVEMemento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class GVEDrawingPanel extends JLayeredPane {

    GVEComposite picture = new GVEComposite();

    GVEShape tempShape;

    /**
     * Memento pattern
     */


    /**
     * Sets state of this GraphPanel using specified memento.
     *
     * @param memento contains state of GraphPanel.
     */
    public void setGPState(GVEMemento memento) {
        //TODO: Implement
    }

    /**
     * Save state of graph for undoing and redoing.
     */
    public void saveGPState() {
        //TODO: Implement
    }


    public void setHandlerState(AbstractState state) {
        for (MouseListener ml : getMouseListeners()) {
            removeMouseListener(ml);
        }
        for (MouseMotionListener ml : getMouseMotionListeners()) {
            removeMouseMotionListener(ml);
        }
        addMouseListener(state);
        addMouseMotionListener(state);
    }

    public void selectShape(int x, int y) {
        //TODO: Implement selecting
    }

    public void addTempShape(){
        if (tempShape != null && !picture.getChilds().contains(this.tempShape)){
            picture.add(tempShape);
            System.out.println("lol");
        }
        System.out.println("lol1");
    }

    public void setTempShape(GVEShape shape) {
        this.tempShape = shape;
    }

    public GVEShape getTempShape(){
        return this.tempShape;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        picture.draw(g2d);
        System.out.println(picture.getChilds().size());

        if (tempShape != null) {
            tempShape.draw(g2d);
        }
    }
}
