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
    private List<GVEShape> childs = new ArrayList<GVEShape>();

    public GVEComposite(){
        super();
    }

    GVEComposite(int posX, int posY, int width, int height) {
        super(posX, posY, width, height);
    }

    public void add(GVEShape child) {
        childs.add(child);
    }

    public void remove(GVEShape child) {
        childs.remove(child);
    }

    @Override
    public void draw(Graphics g) {
        for (GVEShape c : childs)
            c.draw(g);
    }

    public List<GVEShape> getChilds() {
        return childs;
    }

    @Override
    public void move(int x, int y) {

    }
}
