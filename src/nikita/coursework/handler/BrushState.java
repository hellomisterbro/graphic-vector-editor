package nikita.coursework.handler;

import nikita.coursework.GVEFrame;
import nikita.coursework.composite.GVEBrush;
import nikita.coursework.widget.GVEDrawingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/**
 * Created by nikita on 17.05.16.
 */
public class BrushState extends AbstractState {

    GVEBrush brush;

    JTextField widthField, heigthField;
    JTextField positionX, positionY;
    JTextField radious;
    JTextField red, green, blue;

    public BrushState(GVEDrawingPanel panel, JPanel inspector) {
        super(panel, inspector);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        brush = new GVEBrush(e.getX(), e.getY(), 1);
        brush.add(e.getPoint());
        brush.setColor(new Color(43, 43, 43));
        brush.setThickness(3);
        panel.setTempShape(brush);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        ((GVEBrush) panel.getTempShape()).add(e.getPoint());

        widthField.setText(Double.toString(brush.getWidth()));
        heigthField.setText(Double.toString(brush.getHeight()));
        positionX.setText(Double.toString(brush.getX()));
        positionY.setText(Double.toString(brush.getY()));
        radious.setText(Integer.toString(brush.getThickness()));
        red.setText(String.valueOf(brush.getColor().getRed()));
        green.setText(String.valueOf(brush.getColor().getGreen()));
        blue.setText(String.valueOf(brush.getColor().getBlue()));

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
 *  Panel for position init
 */
        JPanel positionPanel = new JPanel();
        JLabel positionName = new JLabel("Position:");
        positionX = new JTextField();
        positionY = new JTextField();
        positionX.addActionListener(e->{
            brush.setX(Double.parseDouble(positionX.getText()));
            panel.repaint();
        });
        positionY.addActionListener(e->{
            brush.setY(Double.parseDouble(positionY.getText()));
            panel.repaint();
        });
        positionPanel.setLayout(new BoxLayout(positionPanel, BoxLayout.LINE_AXIS));
        positionPanel.setMaximumSize(new Dimension(200, 20));
        positionPanel.add(positionName);
        positionPanel.add(new JLabel("  x:"));
        positionPanel.add(positionX);
        positionPanel.add(new JLabel("  y:"));
        positionPanel.add(positionY);



        /**
         *  Panel for size init
         */
        JPanel sizedPanel = new JPanel();
        JLabel sizeName = new JLabel("Size:      ");
        widthField = new JTextField();

        widthField.addActionListener(e->{
            brush.setWidth(Double.parseDouble(widthField.getText()));
            panel.repaint();
        });
        heigthField = new JTextField();
        heigthField.addActionListener(e->{
            brush.setHeight( Double.parseDouble(heigthField.getText()));
            panel.repaint();
        });
        sizedPanel.setLayout(new BoxLayout(sizedPanel, BoxLayout.LINE_AXIS));
        sizedPanel.setMaximumSize(new Dimension(200, 20));
        sizedPanel.add(sizeName);
        sizedPanel.add(new JLabel("  w:"));
        sizedPanel.add(widthField);
        sizedPanel.add(new JLabel("  h:"));
        sizedPanel.add(heigthField);

        /**
         *  Panel for border init
         */
        JPanel borderPanel = new JPanel();
        borderPanel.setLayout(new BoxLayout(borderPanel, BoxLayout.PAGE_AXIS));
        JPanel borderThicknessPanel = new JPanel();
        JPanel redGreenBlueBorderPanel = new JPanel();
        JLabel borderName = new JLabel("Radious:   ");

        radious = new JTextField();
        radious.addActionListener(e -> {
            brush.setThickness(Integer.parseInt(radious.getText()));
            panel.repaint();
        });

        red = new JTextField();
        red.addActionListener(e -> {
            brush.setColor(new Color(Integer.parseInt(red.getText()), brush.getColor().getGreen(),brush.getColor().getBlue()));
            panel.repaint();
        });

        green = new JTextField();
        green.addActionListener(e -> {
            brush.setColor(new Color(brush.getColor().getRed(), Integer.parseInt(green.getText()),brush.getColor().getBlue()));
            panel.repaint();
        });

        blue = new JTextField();
        blue.addActionListener(e -> {
            brush.setColor(new Color(brush.getColor().getRed(), brush.getColor().getGreen(),Integer.parseInt(blue.getText())));
            panel.repaint();
        });

        borderThicknessPanel.setLayout(new BoxLayout(borderThicknessPanel, BoxLayout.LINE_AXIS));
        borderThicknessPanel.setMaximumSize(new Dimension(200, 20));
        borderThicknessPanel.add(borderName);
        borderThicknessPanel.add(radious);


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
        inspector.add(positionPanel);
        inspector.add(Box.createRigidArea(new Dimension(20, 20)));
        inspector.add(sizedPanel);
        inspector.add(Box.createRigidArea(new Dimension(20, 20)));
        inspector.add(borderPanel);
    }
}
