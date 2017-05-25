package Unit2.Task3.implementations;

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
