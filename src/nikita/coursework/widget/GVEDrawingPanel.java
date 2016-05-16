package nikita.coursework.widget;

import nikita.coursework.singletone.Picture;
import nikita.coursework.handler.AbstractState;
import nikita.coursework.memento.GVEMemento;

import javax.swing.*;


/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class GVEDrawingPanel  extends JLayeredPane{

    Picture picture;

    /**
     * Memento pattern
     */


    /**
     * Sets state of this GraphPanel using specified memento.
     *
     * @param memento contains state of GraphPanel.
     */
    public void setGPState(GVEMemento memento) {
        //TODO: Implement
    }

    /**
     * Save state of graph for undoing and redoing.
     */
    public void saveGPState() {
        //TODO: Implement
    }


    public void setHandlerState(AbstractState state) {
        //TODO: Implement
    }


}
