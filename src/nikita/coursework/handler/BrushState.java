package nikita.coursework.handler;

import nikita.coursework.GVEFrame;
import nikita.coursework.composite.GVEBrush;
import nikita.coursework.widget.GVEDrawingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by nikita on 17.05.16.
 */
public class BrushState extends AbstractState {

    public BrushState(GVEDrawingPanel panel, JPanel inspector) {
        super(panel, inspector);
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

    @Override
    protected void setInnerElements(JPanel inspector) {


        /**
         *  Panel for border init
         */
        JPanel borderPanel = new JPanel();
        borderPanel.setLayout(new BoxLayout(borderPanel, BoxLayout.PAGE_AXIS));
        JPanel borderThicknessPanel = new JPanel();
        JPanel redGreenBlueBorderPanel = new JPanel();
        JLabel borderName = new JLabel("Thickness:   ");
        JTextField thickness = new JTextField();
        JTextField red = new JTextField();
        JTextField green = new JTextField();
        JTextField blue = new JTextField();

        borderThicknessPanel.setLayout(new BoxLayout(borderThicknessPanel, BoxLayout.LINE_AXIS));
        borderThicknessPanel.setMaximumSize(new Dimension(200, 20));
        borderThicknessPanel.add(borderName);
        borderThicknessPanel.add(thickness);


        redGreenBlueBorderPanel.setLayout(new BoxLayout(redGreenBlueBorderPanel, BoxLayout.LINE_AXIS));
        redGreenBlueBorderPanel.setMaximumSize(new Dimension(200, 30));
        redGreenBlueBorderPanel.add(new JLabel("R:"));
        redGreenBlueBorderPanel.add(red);
        redGreenBlueBorderPanel.add(new JLabel("G:"));
        redGreenBlueBorderPanel.add(green);
        redGreenBlueBorderPanel.add(new JLabel("B:"));
        redGreenBlueBorderPanel.add(blue);

        borderPanel.add(new JLabel("Brush:"));
        borderPanel.add(borderThicknessPanel);
        borderPanel.add(redGreenBlueBorderPanel);

        inspector.add(Box.createRigidArea(new Dimension(20, 20)));
        inspector.add(borderPanel);
    }
}
