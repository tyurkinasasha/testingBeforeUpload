package practice.arrayList;

/**
 * Created by Tyurkina Alexandra on 5/30/2017.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        System.out.println(list.size());
        System.out.println(list.toString());
    }
}
