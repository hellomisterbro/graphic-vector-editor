package nikita.coursework.command;

import nikita.coursework.memento.GVECaretaker;
import nikita.coursework.widget.GVEDrawingPanel;

import java.awt.event.ActionEvent;

public class RedoCommand extends AbstractCommand {

    private GVECaretaker caretaker;

    public RedoCommand(GVECaretaker caretaker, GVEDrawingPanel panel) {
        super(panel);
        this.caretaker = caretaker;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print("REDO");
        panel.setGPState(caretaker.redo());
    }

}
