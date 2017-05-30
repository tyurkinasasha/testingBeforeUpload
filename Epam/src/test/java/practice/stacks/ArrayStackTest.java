package practice.stacks;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by Tyurkina Alexandra on 5/30/2017.
 */
public class ArrayStackTest {
    Stack<Integer> stack=new LinkedListStack<>();
    @Test
    public void push() throws Exception {
        stack.push(5);
        stack.push(3);
        stack.push(2);

        assertEquals(2,(int)stack.pop());
        assertEquals(3,(int)stack.pop());
        assertEquals(5,(int)stack.pop());

//        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("output.txt"));
//        ByteArrayOutputStream baos=new ByteArrayOutputStream();
//        System.setOut(new PrintStream(baos));
//        byte[] bytes=baos.toByteArray();
//        ByteArrayInputStream bais=new ByteArrayInputStream(bytes);
    }

    @Test
    public void pop() throws Exception {
    }

    @Test
    public void size() throws Exception {
    }

}