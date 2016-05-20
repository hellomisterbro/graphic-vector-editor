package nikita.coursework.handler;

import nikita.coursework.composite.GVEOval;
import nikita.coursework.widget.GVEDrawingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class OvalState extends AbstractState {

    GVEOval oval;
    JTextField thickness;
    JTextField red, green, blue;
    JTextField x, y, width, height;

    public OvalState(GVEDrawingPanel panel, JPanel inspector){
        super(panel, inspector);
    }

    public void setOval(GVEOval oval) {
        this.oval = oval;
        updateUI();
    }

    public void updateUI(){
        thickness.setText(String.valueOf(oval.getThickness()));
        red.setText(String.valueOf(oval.getColor().getRed()));
        green.setText(String.valueOf(oval.getColor().getGreen()));
        blue.setText(String.valueOf(oval.getColor().getBlue()));
        x.setText(String.valueOf((int)oval.getX()));
        y.setText(String.valueOf((int)oval.getY()));
        width.setText(String.valueOf((int)oval.getWidth()));
        height.setText(String.valueOf((int)oval.getHeight()));
    }


    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        oval = new GVEOval(e.getX(), e.getY(), 0, 0);
        this.panel.setTempShape(oval);
        updateUI();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);

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

        x = new JTextField();
        x.addActionListener(e -> {
            oval.setX(Integer.parseInt(x.getText()));
            panel.repaint();
        });

        y = new JTextField();
        y.addActionListener(e -> {
            oval.setX(Integer.parseInt(y.getText()));
            panel.repaint();
        });

        positionPanel.setLayout(new BoxLayout(positionPanel, BoxLayout.LINE_AXIS));
        positionPanel.setMaximumSize(new Dimension(200, 20));
        positionPanel.add(positionName);
        positionPanel.add(x);
        positionPanel.add(y);

        inspector.add(Box.createRigidArea(new Dimension(20, 20)));
        inspector.add(positionPanel);

        /**
         *  Panel for size init
         */
        JPanel sizedPanel = new JPanel();
        JLabel sizeName = new JLabel("Size:      ");
        width = new JTextField();
        width.addActionListener(e -> {
            oval.setWidth(Integer.parseInt(width.getText()));
            panel.repaint();
        });
        height = new JTextField();
        height.addActionListener(e -> {
            oval.setHeight(Integer.parseInt(height.getText()));
            panel.repaint();
        });
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
        thickness = new JTextField();
        thickness.addActionListener(e -> {
            oval.setThickness(Integer.parseInt(thickness.getText()));
            panel.repaint();
        });

        borderThicknessPanel.setLayout(new BoxLayout(borderThicknessPanel, BoxLayout.LINE_AXIS));
        borderThicknessPanel.setMaximumSize(new Dimension(200, 20));
        borderThicknessPanel.add(borderName);
        borderThicknessPanel.add(thickness);



        borderPanel.add(new JLabel("Border:"));
        borderPanel.add(borderThicknessPanel);
        borderPanel.add(redGreenBlueBorderPanel);

        /**
         *  Panel for color init
         */
        JPanel colorPanel = new JPanel();
        colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.PAGE_AXIS));
        JPanel colorRedGreenBluePanel = new JPanel();
        red = new JTextField();
        red.addActionListener(e -> {
            oval.setColor(new Color(Integer.parseInt(red.getText()), oval.getColor().getGreen(), oval.getColor().getBlue()));
            panel.repaint();
        });

        green = new JTextField();
        green.addActionListener(e -> {
            oval.setColor(new Color(oval.getColor().getRed(), Integer.parseInt(green.getText()), oval.getColor().getBlue()));
            panel.repaint();
        });

        blue = new JTextField();
        blue.addActionListener(e -> {
            oval.setColor(new Color(oval.getColor().getRed(), oval.getColor().getGreen(),Integer.parseInt(blue.getText())));
            panel.repaint();
        });



        colorRedGreenBluePanel.setLayout(new BoxLayout(colorRedGreenBluePanel, BoxLayout.LINE_AXIS));
        colorRedGreenBluePanel.setMaximumSize(new Dimension(200, 25));
        colorRedGreenBluePanel.add(new JLabel("R:"));
        colorRedGreenBluePanel.add(red);
        colorRedGreenBluePanel.add(new JLabel("G:"));
        colorRedGreenBluePanel.add(green);
        colorRedGreenBluePanel.add(new JLabel("B:"));
        colorRedGreenBluePanel.add(blue);

        colorPanel.add(new JLabel("Color:"));
        colorPanel.add(colorRedGreenBluePanel);

        inspector.add(Box.createRigidArea(new Dimension(20, 20)));
        inspector.add(sizedPanel);
        inspector.add(Box.createRigidArea(new Dimension(20, 20)));
        inspector.add(colorPanel);
        inspector.add(Box.createRigidArea(new Dimension(20, 20)));
        inspector.add(borderPanel);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
