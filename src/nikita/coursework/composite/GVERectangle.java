package nikita.coursework.composite;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class GVERectangle extends GVEShape {


    public GVERectangle(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        Rectangle2D oval = new Rectangle2D.Float(x, y, width, height);
        g2d.draw(oval);
        g2d.dispose();
    }

    @Override
    public void move(int x, int y) {
        //TODO: Implement
    }
}
