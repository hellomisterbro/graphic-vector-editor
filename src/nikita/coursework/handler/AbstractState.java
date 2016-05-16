package nikita.coursework.handler;

import nikita.coursework.widget.GVEDrawingPanel;

import java.awt.event.MouseAdapter;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
abstract public class AbstractState extends MouseAdapter {
    protected GVEDrawingPanel panel;

    protected AbstractState(GVEDrawingPanel panel){
        this.panel = panel;
    }
}
