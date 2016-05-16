package nikita.coursework.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikita on 11.05.16.
 *
 * @author nikita
 */
public class GVECaretacker {

    private static final int MAX_MEMENTOS = 20;

    private List<GVEMemento> mementoList;

    private int position;


    public GVECaretacker() {
        // Creates empty ArrayList and initialize it with empty picture
        mementoList = new ArrayList<>(MAX_MEMENTOS);

        position = -1;
    }

    /**
       * Returns earlier state.
       *
       * @return earlier state.
    **/
    public GVEMemento undo() {
        if (position > 0)
            position--;

        return mementoList.get(position);
    }

    /**
     * Returns later state.
     *
     * @return Later state.
     */
    public GVEMemento redo() {
        if (position + 1 < mementoList.size())
            position++;
        return mementoList.get(position);
    }



    /**
     * Adds the specified memento to the end of the list.
     * If list is full(contains MAX_MEMENTOS elements),
     * deletes first element.
     *
     * @param memento Memento to be added
     */
    public void add(GVEMemento memento) {

        if (position + 1 != mementoList.size()) {
            for (int i = mementoList.size() - 1; i > position; i--) {
                mementoList.remove(i);
            }
        }

        if (mementoList.size() == MAX_MEMENTOS) {
            mementoList.remove(0);
            position--;
        }

        mementoList.add(memento);
        position++;
    }
}

