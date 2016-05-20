package nikita.coursework.widget;


import nikita.coursework.composite.GVEComposite;
import nikita.coursework.composite.GVEShape;
import nikita.coursework.handler.AbstractState;
import nikita.coursework.memento.GVECaretaker;
import nikita.coursework.memento.GVEMemento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class GVEDrawingPanel extends JLayeredPane {

    public void onSaveAction(ActionEvent actionEvent) {

        final JFileChooser chooser = new JFileChooser();

        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {

            try {
                ObjectOutputStream stream = new ObjectOutputStream(
                        new FileOutputStream(chooser.getSelectedFile())
                );

                stream.writeObject(picture);

            } catch (Exception ignored) {}
        }

    }

    public void onLoadAction(ActionEvent actionEvent) {

        final JFileChooser chooser = new JFileChooser();

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            try {
                ObjectInputStream stream = new ObjectInputStream(
                        new FileInputStream(chooser.getSelectedFile())
                );

                this.picture = (GVEComposite) stream.readObject();
                this.repaint();

            } catch (Exception ignored) { }
        }

    }


    private GVEComposite picture = new GVEComposite();

    private ArrayList<GVEShape> group = new ArrayList<>();

    private Rectangle2D.Float frame = new Rectangle2D.Float();
    private GVECaretaker caretaker;

    GVEShape tempShape;

    /**
     * Memento pattern
     */

    public GVEDrawingPanel(GVECaretaker caretaker){
        this.caretaker = caretaker;
        saveGPState();
    }

    private GVEMemento getGPState() {
        return new GVEMemento((GVEComposite) picture.clone());
    }
    /**
     * Sets state of this GraphPanel using specified memento.
     *
     * @param memento contains state of GraphPanel.
     */
    public void setGPState(GVEMemento memento) {
        removeAll();
        picture = memento.getState();
        group.clear();
//        for (GraphShape element : graph) {
//            add(labelHashMap.get(element));
//            element.notifyObservers();
//        }
        repaint();
    }

    /**
     * Save state of graph for undoing and redoing.
     */
    public void saveGPState() {
        caretaker.add(getGPState());
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


    public void addTempShape(){
        if (tempShape != null && !picture.getChilds().contains(this.tempShape)){
            picture.add(tempShape);
        }
    }

    public void setTempShape(GVEShape shape) {
        this.tempShape = shape;
    }

    public GVEComposite getPicture(){
        return picture;
    }




    public GVEShape getTempShape(){
        return this.tempShape;
    }

    public ArrayList<GVEShape> getGroup(){
        return group;
    }

    public GVEShape selectElement(int x, int y){
        for(GVEShape shape: picture.getChilds())
            if (shape.containsPoint(x, y))
                return shape;
        return null;
    }

    /**
     * Sets rectangle of the selection frame.
     *
     * @param x      coordinate along X axis.
     * @param y      coordinate along Y axis.
     * @param width  of the rectangle.
     * @param height of the rectangle.
     */
    public void setFrame(int x, int y, int width, int height) {
        frame.setRect(x, y, width, height);
        repaint();
    }

    /**
     * Creates group from element in selection frame.
     */
    public void createGroup() {
        group.clear();
        for (GVEShape child : picture.getChilds()) {
            if (frame.contains(child.getX(), child.getY())) {
                group.add(child);
            }
        }
        repaint();
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        picture.draw(g2d);

        if (tempShape != null) {
            tempShape.draw(g2d);
        }

        if (frame.getHeight() != 0 && frame.getWidth() != 0) {
            ((Graphics2D) g).setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
                    10.0f, new float[]{5.0f}, 0.0f/*ставь не думая*/));
            ((Graphics2D) g).draw(frame);
        }
    }


}
