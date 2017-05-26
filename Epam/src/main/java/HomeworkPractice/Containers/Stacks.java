package HomeworkPractice.Containers;

import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
        Stack stack=new Stack();
        for (int i = 0; i < 7; i++) {
            stack.push(new Integer(i));
        }
        System.out.println(stack);
        for (int i = 0; i < 3; i++) {
            stack.pop();
        }
        System.out.println(stack);
    }

}
