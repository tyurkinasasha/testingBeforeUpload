package practice.stacks;

/**
 * Created by Tyurkina Alexandra on 5/30/2017.
 */
public interface Stack<E> {
    void push(E obj);
    E pop();
    int size();
}
