package practice.brackets;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(matches(input));
    }

    public static boolean matches(String input) {
        Stack<String> stack = new Stack<String>();
        String lastOpener = "";
        String[] chars = input.split("");
        Pattern opener = Pattern.compile("[({\\[]");
        Pattern closer = Pattern.compile("[)}\\]]");
        for (String aChar : chars) {
            Matcher matcher = opener.matcher(aChar);
            Matcher matcher2 = closer.matcher(aChar);
            if (matcher.matches()) {
                lastOpener = aChar;
                stack.push(aChar);
            }
            else if (matcher2.matches()) {
                try {
                    if (checkOpener(lastOpener, aChar)) {
                        stack.pop();
                        lastOpener = stack.empty() ? "" : stack.peek();
                    }
                    else return false;
                } catch (EmptyStackException e) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private static boolean checkOpener(String lastOpener, String aChar) {
        boolean result = false;
        switch (aChar.toCharArray()[0]) {
            case ')':
                result = lastOpener.equals("(");
                break;
            case ']':
                result = lastOpener.equals("[");
                break;
            case '}':
                result = lastOpener.equals("{");
                break;
            default:
                break;
        }
        return result;
    }
}