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

    private void writeObject(java.io.ObjectOutputStream stream) throws java.io.IOException {
        stream.defaultWriteObject();
    }

    private void readObject(java.io.ObjectInputStream stream) throws java.io.IOException, ClassNotFoundException {
        stream.defaultReadObject();
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

        if(frame != null)
            drawFrame(g);
    }

    @Override
    public GVEShape clone() {
        return null;
    }

}
