package practice.arrayList;

import java.util.Arrays;

/**
 * Created by Tyurkina Alexandra on 5/30/2017.
 */
public class ArrayList<E> implements List<E> {
    private final int DEFAULT_CAPACITY = 20;
    Object[] objects;

    public ArrayList() {
        objects = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(E obj) {
        if (objects.length == size()) {
            increaseCapacity();
            add(obj);
        } else objects[size()]=obj;
        //if not enough, make new array (with new capacity that is double of default capacity)
    }

    @Override
    public E get(int i) {
        return null;
        //return i-ый element of array
    }

    @Override
    public void remove(int i) {
        //remove

    }

    @Override
    public String toString() {
        return "ArrayList{" + Arrays.toString(objects) +
                '}';
    }

    @Override
    public int size() {
        int k = 0;
        for (Object object : objects) {
            if (object != null) k++;
        }
        return k;
        //count how many elements are in array
    }

    private void increaseCapacity() {
        // check if array size is enough if not increase
        //if not create new one with increased capacity
        int newCapacity = DEFAULT_CAPACITY * 2;
        objects = Arrays.copyOf(objects, newCapacity);

    }
}
