package nikita.coursework.composite;

import java.awt.*;
import java.awt.geom.Ellipse2D;
;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class GVEOval extends GVEShape {

    public GVEOval(double posX, double posY, double width, double height) {
        super(posX, posY, width, height);
    }

    @Override
    public void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(color);
        g2d.fillOval((int)(x), (int)(y),
                (int)(width), (int)(height));
        g2d.dispose();

        g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(thickness));
        Ellipse2D oval = new Ellipse2D.Double(x, y, width, height);
        g2d.draw(oval);
        g2d.dispose();
    }

    @Override
    public void move(double x, double y) {
        //TODO: Implement
    }
}
