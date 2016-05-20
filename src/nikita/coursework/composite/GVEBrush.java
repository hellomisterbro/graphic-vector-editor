package nikita.coursework.composite;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.*;

/**
 * Created by nikita on 17.05.16.
 */
public class GVEBrush extends GVEShape {
    private java.util.List<Point> points = new ArrayList<Point>();


    public GVEBrush(double x, double y, int radious) {
        super(x, y, radious, radious);
        this.thickness = radious;
    }


    public void add(Point point) {
        points.add(point);
        setNewProperties();
    }


    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 1; i < points.size(); i++)
            g2d.draw(new Line2D.Double(points.get(i - 1), points.get(i)));
        g2d.dispose();

        if(frame != null)
            drawFrame(g);
    }

    private void setNewProperties() {
        double minX = Double.MAX_VALUE, minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE, maxY = Double.MIN_VALUE;
        for (Point p : points) {
            if (p.getX() < minX)
                minX = p.getX();
            if (p.getY() < minY)
                minY = p.getY();
            if (p.getX() > maxX)
                maxX = p.getX();
            if (p.getY() > maxY)
                maxY = p.getY();
        }
        if (minY != Double.MAX_VALUE)
            this.y = minY;
        if (minX != Double.MAX_VALUE)
            this.x = minX;
        if (maxX != Double.MIN_VALUE || minX != Double.MAX_VALUE)
            width = maxX - minX;
        if (maxY != Double.MIN_VALUE || minY != Double.MAX_VALUE)
            height = maxY - minY;
    }


    @Override
    public void setX(double x) {
        if (points !=null)
            for (Point p : points) {
                p.setLocation(p.getX() - this.x + x, p.getY());
            }
        super.setX(x);

    }

    @Override
    public void setY(double y) {
        if (points !=null)
        for (Point p: points) {
            p.setLocation(p.getX(), p.getY() + y - this.y);
        }
        super.setY(y);
    }

    public void setWidth(double width) {
        if (points != null)
            for (Point p : points) {
                p.setLocation(x + (p.getX() - x) * width / this.width, p.getY());

            }

        super.setWidth(width);
    }


    public void setHeight(double height) {
        if (points !=null)
        for (Point p : points) {
            p.setLocation(p.getX(), y + (p.getY() - y) * height / this.height);
        }

        super.setHeight(height);
    }

    @Override
    public void move(double x, double y) {

    }
}
