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

    int radious;

    public GVEBrush(int x, int y, int radious){
        super(x, y, radious, radious);
        this.radious = radious;
    }


    public void add(Point point) {
        points.add(point);
    }

    public int getRadious(){
        return radious;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        //g2d.setColor(new Color(0, 0, 128));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 1; i < points.size(); i++)
            g2d.draw(new Line2D.Float(points.get(i-1), points.get(i)));
        g2d.dispose();
    }

    @Override
    public void move(int x, int y) {

    }
}
