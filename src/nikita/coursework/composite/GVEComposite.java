package nikita.coursework.composite;

import java.awt.*;
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
public class GVEComposite extends GVEShape {
    private List<GVEShape> childs = new ArrayList<>();

    public GVEComposite(){
        super();
    }

    GVEComposite(double posX, double posY, double width, double height) {
        super(posX, posY, width, height);
    }

    public void add(GVEShape child) {
        childs.add(child);
        setNewProperties();
    }

    public void remove(GVEShape child) {
        childs.remove(child);
        setNewProperties();
    }

    public boolean contains(GVEShape shape){
        if (childs.contains(shape))
            return true;
        return false;
    }

    @Override
    public void draw(Graphics g) {
        for (GVEShape c : childs)
            c.draw(g);
        if(frame != null)
            drawFrame(g);
    }


    public List<GVEShape> getChilds() {
        return childs;
    }


    @Override
    public void setX(double x) {
        if (!childs.isEmpty())
            for (GVEShape p : childs) {
                if (p!=null)
                    p.setX(p.getX() - this.x + x);
            }
        super.setX(x);

    }

    @Override
    public void setY(double y) {
        if (!childs.isEmpty())
            for (GVEShape p: childs) {
                if (p!=null)
                    p.setY(p.getY() + y - this.y);
            }
        super.setY(y);
    }

    public void setWidth(double width) {


        for (GVEShape p : childs) {
            p.setWidth(p.width*(this.width/width));

        }
        super.setWidth(width);
    }


    public void setHeight(double height) {
        for (GVEShape p : childs) {
            p.setWidth(p.height*(this.height/height));

        }
        super.setHeight(height);
    }


    private void setNewProperties() {

        double minX = Double.MAX_VALUE, minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE, maxY = Double.MIN_VALUE;
        for (GVEShape p : childs) {
            if (p.getX() < minX)
                minX = p.getX();
            if (p.getY() < minY)
                minY = p.getY();
            if (p.getX() + p.getWidth() > maxX)
                maxX = p.getX() + p.getWidth();
            if (p.getY() + p.getHeight() > maxY)
                maxY = p.getY() + p.getHeight();
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
    public GVEShape clone() {
        GVEComposite comp = new GVEComposite();
        for (GVEShape shape: childs){
            comp.add(shape);
        }
        return comp;
    }
}
