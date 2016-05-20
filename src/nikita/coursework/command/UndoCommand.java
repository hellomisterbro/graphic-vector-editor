package nikita.coursework.command;

import nikita.coursework.memento.GVECaretaker;
import nikita.coursework.widget.GVEDrawingPanel;

import java.awt.event.ActionEvent;

public class UndoCommand extends AbstractCommand {

    private GVECaretaker caretaker;


    public UndoCommand(GVECaretaker caretaker, GVEDrawingPanel panel) {
        super(panel);
        this.caretaker = caretaker;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.setGPState(caretaker.undo());
    }

}
