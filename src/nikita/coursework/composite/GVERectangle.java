package nikita.coursework.composite;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class GVERectangle extends GVEShape {

    double borderThickness = 1;

    public GVERectangle(double posX, double posY, double width, double height) {
        super(posX, posY, width, height);
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);
        g2d.setStroke(new BasicStroke((int)borderThickness));
        g2d.draw(rect);
        g2d.dispose();
    }

    @Override
    public void move(double x, double y) {
        //TODO: Implement
    }

    public void setBorderThickness(double thickness){
        borderThickness = thickness;
    }
}
