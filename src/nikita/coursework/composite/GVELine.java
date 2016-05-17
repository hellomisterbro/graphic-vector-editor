package nikita.coursework.composite;

import java.awt.*;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class GVELine extends GVEShape {

    int x1, y1, x2, y2;

    public GVELine(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void setCords(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawLine(x1, y1, x2, y2);
        g2d.dispose();
    }

    @Override
    public void move(int x, int y) {
        //TODO: Implement
    }
}
