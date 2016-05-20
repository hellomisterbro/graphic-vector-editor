package nikita.coursework.handler;

import nikita.coursework.composite.*;
import nikita.coursework.widget.GVEDrawingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class EditState extends AbstractState {
    //
    private List<GVEShape> group;
    private List<GVEShape> copy;

    JButton groupButton, ungoupButton;

    private int x, y;
    private int x0, y0;
    private int xf, yf;
    private boolean frameCreation = false;
    private boolean dragging = false;
    JPanel inspector;

    public EditState(GVEDrawingPanel panel, JPanel inspector, JButton groupButton, JButton ungoupButton) {
        super(panel, inspector);
        this.inspector = inspector;
        this.group = panel.getGroup();

        groupButton.addActionListener(e -> {
            GVEComposite comp = new GVEComposite();
            for (GVEShape shape: group) {
                shape.removeFrame();
                comp.add(shape);
                panel.getPicture().remove(shape);

            }
            panel.getPicture().add(comp);
            comp.setFrame();
            group.clear();
            group.add(comp);
            panel.repaint();

        });

        ungoupButton.addActionListener(e-> {
            if(group.size() == 1 && group.get(0) instanceof GVEComposite){
                List<GVEShape> copyList = new ArrayList<>();

                GVEComposite comp = (GVEComposite) group.get(0);
                comp.removeFrame();
                for(GVEShape shape: comp.getChilds()){
                    panel.getPicture().add(shape);
                    copyList.add(shape);
                }
                panel.getPicture().remove(comp);
                group.clear();
                for(GVEShape shape: copyList){
                   shape.setFrame();
                    group.add(shape);
                }

                panel.repaint();
            }
        });

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        GVEShape gs = panel.selectElement(e.getX(), e.getY());

        if (gs != null) {
            if (e.isMetaDown()) {
                if (!group.contains(gs)) {
                    group.add(gs);
                    gs.setFrame();
                } else {
                    group.remove(gs);
                    gs.removeFrame();
                }
            } else if (e.isAltDown()) {
                group.remove(gs);
                gs.setFrame();
            } else {
                for (GVEShape g : group)
                    g.removeFrame();
                group.clear();
                if (gs != null)
                    group.add(gs);
                gs.setFrame();
                if (gs instanceof GVERectangle) {
                    RectangleState r = new RectangleState(panel, inspector);
                    r.setRect((GVERectangle) gs);
                    panel.setHandlerState(r);
                } else if (gs instanceof GVEOval) {
                    OvalState r = new OvalState(panel, inspector);
                    r.setOval((GVEOval) gs);
                    panel.setHandlerState(r);
                } else if (gs instanceof GVELine) {
                    LineState r = new LineState(panel, inspector);
                    r.setLine((GVELine) gs);
                    panel.setHandlerState(r);
                } else if (gs instanceof GVEBrush) {
                    BrushState r = new BrushState(panel, inspector);
                    r.setBrush((GVEBrush) gs);
                    panel.setHandlerState(r);
                } else if(gs instanceof GVEComposite){
                    //TODO: Enable button
                }
            }
        } else {

            if (!e.isAltDown() && !e.isControlDown()) {
                for (GVEShape g : group)
                    g.removeFrame();
                group.clear();
            }
        }

    }


    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            if (copy != null)
                copy.clear();
            else
                copy = new ArrayList<>();
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

            for (GVEShape shape : copy)
                shape.setCords(shape.getX() + e.getX() - x, shape.getY() + e.getY() - y);

            panel.repaint();

            x = e.getX();
            y = e.getY();
        } else if (frameCreation) {
            int minX = Math.min(e.getX(), xf);
            int minY = Math.min(e.getY(), yf);
            int maxX = minX ^ e.getX() ^ xf;
            int maxY = minY ^ e.getY() ^ yf;

            panel.setFrame(minX, minY, maxX - minX, maxY - minY);
            for (GVEShape shape : group)
                shape.removeFrame();
            panel.createGroup();
            for (GVEShape shape : group)
                shape.setFrame();

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (dragging) {
            panel.setTempShape(null);
            dragging = false;
            copy = null;
        } else if (frameCreation) {
            panel.setFrame(xf, yf, 0, 0);
            frameCreation = false;
        }
        panel.repaint();
    }

    @Override
    protected void setInnerElements(JPanel inspector) {

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {


        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            for (GVEShape shape : group) {
                if (panel.getPicture().contains(shape)) {
                    panel.getPicture().remove(shape);
                }
            }
            for (GVEShape g : group)
                g.removeFrame();
            group.clear();
            panel.setTempShape(null);
            panel.repaint();
        }
    }
}
