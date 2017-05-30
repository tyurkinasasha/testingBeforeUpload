package practice.binarySearch;

/**
 * Created by Tyurkina Alexandra on 5/30/2017.
 */
public class BinarySearch {
    public static int binarySearch(int element,int [] array){
        int low=0;
        int high=array.length-1;
        while (low<=high){
            int middle=(low+high)/2;
            if (element<array[middle]) high=middle-1;
            else if (element>array[middle]) low=middle+1;
            else return middle+1;
        }
        return -1;
    }
}
