package practice.binarySearch;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tyurkina Alexandra on 5/30/2017.
 */
public class BinarySearchTest {
    int [] array=new int[]{2,4,7,9,12,13,14,18,30};
    @Test
    public void binarySearch() throws Exception {
        assertEquals(4,BinarySearch.binarySearch(9,array));
        assertEquals(5,BinarySearch.binarySearch(12,array));
        assertEquals(1,BinarySearch.binarySearch(2,array));
        assertEquals(8,BinarySearch.binarySearch(18,array));
    }

}