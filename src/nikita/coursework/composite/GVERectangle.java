package nikita.coursework.composite;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class GVERectangle extends GVEShape {

    int borderThickness = 1;

    public GVERectangle(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        Rectangle2D rect = new Rectangle2D.Float(x, y, width, height);
        g2d.setStroke(new BasicStroke(borderThickness));
        g2d.draw(rect);
        g2d.dispose();
    }

    @Override
    public void move(int x, int y) {
        //TODO: Implement
    }

    public void setBorderThickness(int thickness){
        borderThickness = thickness;
    }
}
