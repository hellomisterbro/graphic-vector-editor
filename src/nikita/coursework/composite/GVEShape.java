package nikita.coursework.composite;

import java.awt.*;

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
        this.x = posX;
    }

    public void setY(double posY) {
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
