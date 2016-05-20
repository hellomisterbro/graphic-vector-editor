package nikita.coursework.memento;

import nikita.coursework.composite.GVEComposite;

import java.awt.*;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class GVEMemento {

    GVEComposite state;

    public GVEMemento(GVEComposite state) {
        this.state = state;
    }

   public GVEComposite getState(){
        return state;
    }
}
