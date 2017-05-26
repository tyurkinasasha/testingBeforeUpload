package practice.wordsFrequency;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tyurkina Alexandra on 5/26/2017.
 */
public class Main {
    static Map<String, Integer> stat = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    //static final String DELIMS="\\t\\r\\n\\f";
    public static void main(String[] args) {
        Pattern word = Pattern.compile("[a-z]{3,}");

        try (BufferedReader br = new BufferedReader(new FileReader(new Getter().getFile()))) {
            while (br.ready()) {
                sb.append(br.readLine().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringTokenizer st = new StringTokenizer(sb.toString());
        System.out.println(st.countTokens());
        while (st.hasMoreTokens()){
            String s=st.nextToken();
            Matcher matcher=word.matcher(s);
            if (matcher.matches()){
                if (stat.containsKey(s)){
                    int i=stat.get(s);
                    stat.replace(s,++i);
                }
                else stat.put(s,1);
            }
        }
        System.out.println(stat);

    }

    private static InputStreamReader getResource() {
        Class<Main> myClass = Main.class;
        return new InputStreamReader(myClass.getResourceAsStream("war_and_peace.txt"));
    }

    static class Getter {
        File getFile() {
            return new File(getClass().getClassLoader().getResource("war_and_peace.txt").getFile());
        }
    }

}
