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

    GVEBrush brush;

    JTextField widthField;
    JTextField heigthField;
    JTextField positionX;
    JTextField positionY;

    public BrushState(GVEDrawingPanel panel, JPanel inspector) {
        super(panel, inspector);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        brush = new GVEBrush(e.getX(), e.getY(), 1);
        brush.add(e.getPoint());
        panel.setTempShape(brush);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        ((GVEBrush) panel.getTempShape()).add(e.getPoint());
        //    System.out.println("x: " + brush.getX() + "; y: " + brush.getY() + "; w: " + brush.getWidth() + "; h: " + brush.getHeight() );
        widthField.setText(Integer.toString(brush.getWidth()));
        heigthField.setText(Integer.toString(brush.getHeight()));
        positionX.setText(Integer.toString(brush.getX()));
        positionY.setText(Integer.toString(brush.getY()));
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
            brush.setX(Integer.parseInt(positionX.getText()));
            panel.repaint();
        });
        positionY.addActionListener(e->{
            brush.setY(Integer.parseInt(positionY.getText()));
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
            brush.resizeBrushWidth(Integer.parseInt(widthField.getText()));
            panel.repaint();
        });
        heigthField = new JTextField();
        heigthField.addActionListener(e->{
            System.out.println("saddasdas");
            brush.resizeBrushHeight( Integer.parseInt(heigthField.getText()));
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
        JTextField radious = new JTextField();
        radious.addActionListener(e -> {
            brush.setRadious(Integer.parseInt(radious.getText()));
            panel.repaint();
        });
        JTextField red = new JTextField();
        JTextField green = new JTextField();
        JTextField blue = new JTextField();

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
