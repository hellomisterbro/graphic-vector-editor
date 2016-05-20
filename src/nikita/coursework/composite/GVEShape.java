package nikita.coursework.composite;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public abstract class GVEShape {
    protected double x = 0, y =0;
    protected double width = 0, height = 0;

    protected Color color = new Color(245, 245, 245);
    protected int thickness = 1;

    Rectangle2D frame = null;

    GVEShape(){}

    GVEShape(double x, double y, double width, double height){
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    public void setCords(double posX, double posY) {
        setX(posX);
        setY(posY);
    }

    public void setSize(double width, double height){
        setWidth(width);
        setHeight(height);
    }

    public void setFrame(){
        frame = new Rectangle2D.Double(x - 3, y - 3, width + 6, height + 6);
    }

    public void removeFrame(){
        frame = null;
    }


    protected void drawFrame(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
                10.0f, new float[]{5.0f}, 0.0f/*ставь не думая*/));
        Rectangle2D rect = frame;
        g2d.draw(rect);
        g2d.dispose();
    }


    public boolean containsPoint(double x, double y) {
        return (this.x < x &&  x < this.x + width) && (this.y < y &&  y < this.y + height);
    }
    public Color getColor() {
        return color;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public int getThickness() {
        return thickness;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setX(double posX) {
        if (frame != null){
            frame = new Rectangle2D.Double(posX - 3, frame.getY(), frame.getWidth(), frame.getHeight());
        }
        this.x = posX;
    }

    public void setY(double posY) {
        if (frame != null){
            frame = new Rectangle2D.Double(frame.getX(), posY - 3, frame.getWidth(), frame.getHeight());
        }
        this.y = posY;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public abstract void draw(Graphics g);

    public abstract void move(double x, double y);

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }
}
