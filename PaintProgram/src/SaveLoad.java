import java.io.*;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 * Save Figures stored in a LinkList
 */
public class SaveLoad {

    //----Constructor---------------------------------------------------------

    /**
     * Constructor, creates empty new object.
     * Takes no parameters.
     */
    public SaveLoad() {
    }
    //------------------------------------------------------------------------
    //----Methods-------------------------------------------------------------

    /**
     * Save method.
     * @param f LinkedList with Figures that are to be saved
     */
    public void save(LinkedList<Figures> f) {
        try {
            String s = JOptionPane.showInputDialog("Give a file name for save operation:");
            //If cancel or no filename selected
            if(s == null){
                return;
            }
            FileOutputStream output = new FileOutputStream(s);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(output);
            objectOutputStream.writeObject(f);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("Write failed, because " + e);
        }
    }

    /**
     * Load method.
     * @return a LinkedList<Figures>
     */
    public LinkedList<Figures> load() {
        try {
            String l = JOptionPane.showInputDialog("Give a file name for load operation:");
            //If abort or no filename selected
            if(l == null){
                return new LinkedList<Figures>();
            }
            FileInputStream input = new FileInputStream(l);
            ObjectInputStream objectInputStream = new ObjectInputStream(input);
            LinkedList<Figures> figures = (LinkedList<Figures>) (objectInputStream.readObject());
            objectInputStream.close();
            System.out.println("Load complete");
            return figures;
        } catch (Exception e) {
            System.out.println("Load failed, because " + e);
            return new LinkedList<Figures>();
        }
    }
    //------------------------------------------------------------------------
}

