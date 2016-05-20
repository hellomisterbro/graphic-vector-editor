package nikita.coursework.composite;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class GVELine extends GVEShape {

    double x1 = 0, y1 = 0, x2 = 0, y2 = 0;

    public GVELine(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public void setCords(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.x = (x1 < x2) ? x1 : x2;
        this.y = (y1 < y2) ? y1 : y2;
        this.height = ((y1 > y2) ? y1 : y2) - ((y1 < y2) ? y1 : y2);
        this.width = ((x1 > x2) ? x1 : x2) - ((x1 < x2) ? x1 : x2);
    }

    @Override
    public void setX(double posX) {
        double delta = posX - x;
        x1 = x1 + delta;
        x2 = x2 + delta;
        super.setX(posX);
    }

    @Override
    public void setY(double posY) {
        double delta = posY- y;
        y1 = y1 + delta;
        y2 = y2 + delta;
        super.setY(posY);
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getY1() {
        return y1;
    }

    public double getY2() {
        return y2;
    }

    @Override
    public void setWidth(double width) {
        if (this.width != 0)
            this.x1 = x + (x - x1) * width / this.width;
        super.setWidth(width);
    }

    @Override
    public void setHeight(double height) {
        if (this.height != 0)
            this.y1 = y + (y - y1) * height / this.height;
        super.setHeight(height);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(thickness));
        g2d.setColor(color);
        Line2D line = new Line2D.Double(x1, y1, x2, y2);
        g2d.draw(line);
        g2d.dispose();

        if(frame != null)
            drawFrame(g);
    }

    @Override
    public void move(double x, double y) {
        //TODO: Implement
    }

    @Override
    public GVEShape clone() {
        return null;
    }
}
