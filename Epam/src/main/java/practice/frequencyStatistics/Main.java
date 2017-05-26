package practice.frequencyStatistics;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tyurkina Alexandra on 5/26/2017.
 */
public class Main {
    private static Map<String, Integer> alphabet1 = new HashMap<>();
    private static String data = "hey my name is sasha i like salad";

    public static void main(String[] args) {
        createAlphabet();
        System.out.println(alphabet1);
        String[] strData = data.split("");
        for (int i = 0; i < strData.length; i++) {
            if (alphabet1.containsKey(strData[i])) {
                int tmp = alphabet1.get(strData[i]);
                tmp++;
                alphabet1.replace(strData[i], tmp);
            }
        }
        System.out.println(alphabet1);

    }

    private static void createAlphabet() {
        int counter = 0;
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            alphabet1.put(ch + "", counter);
        }
    }
}
