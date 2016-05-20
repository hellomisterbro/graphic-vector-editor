package nikita.coursework.command.graph;


import nikita.coursework.command.AbstractCommand;
import nikita.coursework.widget.GVEDrawingPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CutCommand extends AbstractCommand {

    private Action copyCommand;
    private Action deleteCommand;


    public CutCommand(GVEDrawingPanel panel) {
        super(panel);
        ActionMap actions = panel.getActionMap();
        copyCommand = actions.get("Copy");
        deleteCommand = actions.get("Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print("CUT");
        copyCommand.actionPerformed(e);
        deleteCommand.actionPerformed(e);
    }
}
