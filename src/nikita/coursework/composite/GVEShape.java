package nikita.coursework.composite;

import java.awt.*;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public abstract class GVEShape {
    protected int x, y;
    protected int width = 0, height = 0;

    GVEShape(){}

    GVEShape(int x, int y, int width, int height){
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    public void setCords(int posX, int posY) {
        setX(posX);
        setY(posY);
    }

    public void setSize(int width, int height){
        setWidth(width);
        setHeight(height);
    }


    public boolean containsPoint(int x, int y) {
        return (this.x < x &&  x < this.x + width) && (this.y < y &&  y < this.y + height);
    }

    public void setX(int posX) {
        this.x = posX;
    }

    public void setY(int posY) {
        this.y = posY;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract void draw(Graphics g);

    public abstract void move(int x, int y);

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
