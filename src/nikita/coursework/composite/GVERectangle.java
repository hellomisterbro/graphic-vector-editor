package nikita.coursework.composite;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class GVERectangle extends GVEShape {


    public GVERectangle(double posX, double posY, double width, double height) {
        super(posX, posY, width, height);
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(color);
        g2d.fillRect((int)(x), (int)(y),
                (int)(width), (int)(height));
        g2d.dispose();

        g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(thickness));
        Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);
        g2d.draw(rect);
        g2d.dispose();

        if(frame != null)
            drawFrame(g);

    }



    @Override
    public void move(double x, double y) {
        //TODO: Implement
    }

}
