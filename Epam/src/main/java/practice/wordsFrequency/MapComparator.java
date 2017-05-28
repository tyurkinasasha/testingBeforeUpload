package practice.wordsFrequency;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by Tyurkina Alexandra on 5/26/2017.
 */
public class MapComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1,o2);
    }
}
