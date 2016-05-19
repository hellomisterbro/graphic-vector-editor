package nikita.coursework.handler;

import nikita.coursework.composite.GVELine;
import nikita.coursework.widget.GVEDrawingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class LineState extends AbstractState {

    GVELine line;

    JTextField positionX1;
    JTextField positionY1;
    JTextField positionX2;
    JTextField positionY2;

    JTextField thickness;
    JTextField red, green, blue;


    public LineState(GVEDrawingPanel panel, JPanel inspector) {
        super(panel, inspector);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);

        line = new GVELine(e.getX(), e.getY(), 0, 0);
        this.panel.setTempShape(line);
    }
    @Override
    public void mouseDragged(MouseEvent e) {

        line = (GVELine) this.panel.getTempShape();
        if (line != null && line instanceof GVELine) {
             line.setCords(mousePressedX, mousePressedY, e.getX(), e.getY());
            this.panel.repaint();
        }
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
        positionX1 = new JTextField();
        positionY1 = new JTextField();
        positionX1.addActionListener(e->{
            line.setX1(Double.parseDouble(positionX1.getText()));
            panel.repaint();
        });
        positionY1.addActionListener(e->{
            line.setY1(Double.parseDouble(positionY1.getText()));
            panel.repaint();
        });
        positionPanel.setLayout(new BoxLayout(positionPanel, BoxLayout.LINE_AXIS));
        positionPanel.setMaximumSize(new Dimension(200, 20));
        positionPanel.add(positionName);
        positionPanel.add(new JLabel("  x1:"));
        positionPanel.add(positionX1);
        positionPanel.add(new JLabel("  y1:"));
        positionPanel.add(positionY1);



        /**
         *  Panel for size init
         */
        JPanel sizedPanel = new JPanel();
        JLabel sizeName = new JLabel("Size:      ");
        positionX2 = new JTextField();

        positionX2.addActionListener(e->{
            line.setX2(Double.parseDouble(positionX2.getText()));
            panel.repaint();
        });
        positionY2 = new JTextField();
        positionY2.addActionListener(e->{
            line.setY2( Double.parseDouble(positionY2.getText()));
            panel.repaint();
        });
        sizedPanel.setLayout(new BoxLayout(sizedPanel, BoxLayout.LINE_AXIS));
        sizedPanel.setMaximumSize(new Dimension(200, 20));
        sizedPanel.add(sizeName);
        sizedPanel.add(new JLabel("  x2:"));
        sizedPanel.add(positionX2);
        sizedPanel.add(new JLabel("  y2:"));
        sizedPanel.add(positionY2);

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
            System.out.print(thickness.getText());
            line.setThickness(Integer.parseInt(thickness.getText()));
            panel.repaint();
        });

        red = new JTextField();
        red.addActionListener(e -> {
            line.setColor(new Color(Integer.parseInt(red.getText()), line.getColor().getGreen(), line.getColor().getBlue()));
            panel.repaint();
        });

        green = new JTextField();
        green.addActionListener(e -> {
            line.setColor(new Color(line.getColor().getRed(), Integer.parseInt(green.getText()), line.getColor().getBlue()));
            panel.repaint();
        });

        blue = new JTextField();
        blue.addActionListener(e -> {
            line.setColor(new Color(line.getColor().getRed(), line.getColor().getGreen(),Integer.parseInt(blue.getText())));
            panel.repaint();
        });

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
