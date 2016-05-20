package nikita.coursework.command;


import nikita.coursework.widget.GVEDrawingPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class AbstractCommand extends AbstractAction {


    protected GVEDrawingPanel panel;

    protected AbstractCommand(GVEDrawingPanel panel) {
        this.panel = panel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        panel.saveGPState();
    }
}
