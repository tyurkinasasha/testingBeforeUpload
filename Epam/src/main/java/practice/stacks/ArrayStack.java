package practice.stacks;

import java.util.Arrays;

/**
 * Created by Tyurkina Alexandra on 5/30/2017.
 */
public class ArrayStack<E> implements Stack<E> {
    Object[] objects;
    private final int DEFAULT_CAPACITY = 10;
    private int pointer = 0;

    public ArrayStack() {
        objects = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void push(E obj) {
        checkCapacity();
        objects[pointer] = obj;
        pointer++;

    }

    @Override
    public E pop() {
        E tmp= (E) objects[pointer-1];
        objects[pointer-1] = null;
        pointer--;
        return tmp;
    }

    @Override
    public int size() {
        return (pointer);
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                Arrays.toString(objects) +
                '}';
    }

    public void checkCapacity() {
        if (pointer == objects.length) {
            int newCapacity = DEFAULT_CAPACITY * 2;
            objects = Arrays.copyOf(objects, newCapacity);
        }
    }
}
