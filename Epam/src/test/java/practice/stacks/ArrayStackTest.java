package practice.stacks;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tyurkina Alexandra on 5/30/2017.
 */
public class ArrayStackTest {
    Stack<Integer> stack=new ArrayStack<>();
    @Test
    public void push() throws Exception {
        stack.push(5);
        stack.push(3);
        stack.push(2);
        assertEquals(2,(int)stack.pop());
        assertEquals(3,(int)stack.pop());
        assertEquals(5,(int)stack.pop());
    }

    @Test
    public void pop() throws Exception {
    }

    @Test
    public void size() throws Exception {
    }

}