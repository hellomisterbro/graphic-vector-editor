package nikita.coursework.handler;

import nikita.coursework.composite.GVEOval;
import nikita.coursework.composite.GVERectangle;
import nikita.coursework.composite.GVEShape;
import nikita.coursework.widget.GVEDrawingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class OvalState extends AbstractState {
    
    public OvalState(GVEDrawingPanel panel, JPanel inspector){
        super(panel, inspector);
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

    @Override
    protected void setInnerElements(JPanel inspector) {
        /**
         *  Panel for position init
         */
        JPanel positionPanel = new JPanel();
        JLabel positionName = new JLabel("Position:");
        JTextField positionX = new JTextField();
        JTextField positionY = new JTextField();
        positionPanel.setLayout(new BoxLayout(positionPanel, BoxLayout.LINE_AXIS));
        positionPanel.setMaximumSize(new Dimension(200, 20));
        positionPanel.add(positionName);
        positionPanel.add(positionX);
        positionPanel.add(positionY);

        inspector.add(Box.createRigidArea(new Dimension(20, 20)));
        inspector.add(positionPanel);

        /**
         *  Panel for size init
         */
        JPanel sizedPanel = new JPanel();
        JLabel sizeName = new JLabel("Size:      ");
        JTextField width = new JTextField();
        JTextField height = new JTextField();
        sizedPanel.setLayout(new BoxLayout(sizedPanel, BoxLayout.LINE_AXIS));
        sizedPanel.setMaximumSize(new Dimension(200, 20));
        sizedPanel.add(sizeName);
        sizedPanel.add(width);
        sizedPanel.add(height);


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

        borderPanel.add(new JLabel("Border:"));
        borderPanel.add(borderThicknessPanel);
        borderPanel.add(redGreenBlueBorderPanel);

        /**
         *  Panel for color init
         */
        JPanel colorPanel = new JPanel();
        colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.PAGE_AXIS));
        JPanel colorRedGreenBluePanel = new JPanel();
        JTextField colorRed = new JTextField();
        JTextField colorGreen = new JTextField();
        JTextField colorBlue = new JTextField();


        colorRedGreenBluePanel.setLayout(new BoxLayout(colorRedGreenBluePanel, BoxLayout.LINE_AXIS));
        colorRedGreenBluePanel.setMaximumSize(new Dimension(200, 25));
        colorRedGreenBluePanel.add(new JLabel("R:"));
        colorRedGreenBluePanel.add(colorRed);
        colorRedGreenBluePanel.add(new JLabel("G:"));
        colorRedGreenBluePanel.add(colorGreen);
        colorRedGreenBluePanel.add(new JLabel("B:"));
        colorRedGreenBluePanel.add(colorBlue);

        colorPanel.add(new JLabel("Color:"));
        colorPanel.add(colorRedGreenBluePanel);

        inspector.add(Box.createRigidArea(new Dimension(20, 20)));
        inspector.add(sizedPanel);
        inspector.add(Box.createRigidArea(new Dimension(20, 20)));
        inspector.add(colorPanel);
        inspector.add(Box.createRigidArea(new Dimension(20, 20)));
        inspector.add(borderPanel);
    }
}
