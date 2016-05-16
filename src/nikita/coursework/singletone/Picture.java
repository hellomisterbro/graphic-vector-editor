package nikita.coursework.singletone;

import nikita.coursework.composite.Composite;

/**
 * Created by nikita on 11.05.16.
 *
 * This class is used to represent all shapes on the panel.
 *
 * @author nikita
 */
public class Picture {
    static Picture picture;

    private Picture(){
        picture = new Picture();
    }

    public static Picture getPicture(){
        return picture;
    }
}
