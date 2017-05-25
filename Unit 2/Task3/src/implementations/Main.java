package implementations;

/**
 * Created by TyurkinaAlexandra on 10.05.2017.
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        try {
            StarterKit st=new StarterKit();
            System.out.println(st);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
