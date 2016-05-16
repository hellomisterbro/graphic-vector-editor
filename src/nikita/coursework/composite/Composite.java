package nikita.coursework.composite;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by nikita on 11.05.16.
 *
 * Particular shape, which is consist
 * of other shapes and represent them as one.
 *
 * @author nikita
 */
public class Composite extends Shape{
    private List<Shape> childs = new ArrayList<Shape>();

    public Composite(){}

    public Composite(Shape child, double posX, double posY, double width, double height) {
        add(child);
        setX(posX);
        setY(posY);
        setWidth(width);
        setHeight(height);
    }

    public void add(Shape child) {
        //TODO: implement
    }

    public void remove(Shape child) {
        //TODO: implement
    }

}
