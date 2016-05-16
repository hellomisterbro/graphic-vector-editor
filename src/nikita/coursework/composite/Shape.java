package nikita.coursework.composite;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public abstract class Shape {
    protected double posX, posY;
    protected double width, height;

    public void setX(double posX) {
        this.posX = posX;
    }

    public void setY(double posY) {
        this.posY = posY;
    }

    public void setWidth(double width) {
        this.width = width;

    }

    public void setHeight(double height) {
        this.height = height;

    }

    public double getX() {
        return this.posX;
    }

    public double getY() {
        return this.posY;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }
}
