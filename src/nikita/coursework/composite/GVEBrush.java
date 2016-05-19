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

    int radious = 1;
    Color color = new Color(0, 0, 0);

    public GVEBrush(int x, int y, int radious){
        super(x, y, radious, radious);
        this.radious = radious;
    }


    public void add(Point point) {
        points.add(point);
        setNewProperties();
    }

    public int getRadious(){
        return radious;
    }

    public void setRadious(int radious){
        this.radious  = radious;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color){
        this.color  = color;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(radious));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 1; i < points.size(); i++)
            g2d.draw(new Line2D.Float(points.get(i-1), points.get(i)));
        g2d.dispose();
    }

    private void setNewProperties(){
        int minX = Integer.MAX_VALUE, minY= Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        for (Point p: points){
            if (p.getX() < minX)
                minX = (int) p.getX();
            if (p.getY() < minY)
                minY = (int) p.getY();
            if (p.getX() > maxX)
                maxX = (int) p.getX();
            if (p.getY() > maxY)
                maxY = (int) p.getY();
        }
        setY(minY);
        setX(minX);
        setWidth(maxX - minX);
        setHeight(maxY - minY);
    }




    public void resizeBrushWidth(int width){
        for (Point p: points) {
            p.setLocation((double) x + (p.getX() - (double)x)*(double)width/(double)this.width, p.getY());

        }

        super.setWidth(width);
    }


    public void resizeBrushHeight(int height){
        for (Point p: points) {
            p.setLocation(p.getX(), (double) y + (p.getY() - (double)y)*(double)height/(double)this.height);
        }

        super.setHeight(height);
    }

    @Override
    public void move(int x, int y) {

    }
}
