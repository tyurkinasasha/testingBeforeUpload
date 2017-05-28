package practice.wordsFrequency;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tyurkina Alexandra on 5/26/2017.
 */
public class Main {
    static Map<Integer, String> stat = new TreeMap<>(Collections.reverseOrder());
    static StringBuilder sb = new StringBuilder();
//    static MapComparator mp = new MapComparator();

    public static void main(String[] args) {
        Pattern word = Pattern.compile("([a-z]{3,})+");

        try (BufferedReader br = new BufferedReader(new FileReader(new Getter().getFile()))) {
            while (br.ready()) {
                sb.append(br.readLine().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringTokenizer st = new StringTokenizer(sb.toString());
        System.out.println(st.countTokens());
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            Matcher matcher = word.matcher(s);
            if (matcher.matches()) {
                if (stat.containsValue(s)) {
                    int i = getKeyByValue(stat, s);
//                    stat.replace(++i, s);
                    stat.remove(i);
                    stat.put(++i,s);
                } else stat.put(1, s);
            }
        }
        System.out.println(stat.size());
        System.out.println(stat.values().size());

        System.out.println(stat);

    }

    static class Getter {
        File getFile() {
            return new File(getClass().getClassLoader().getResource("war_and_peace.txt").getFile());
        }
    }

    static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

}
