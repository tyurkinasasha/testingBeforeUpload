package practice.brackets;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); //created new scaner that scans over a standrad system.in stream
        String input = in.nextLine();
        System.out.println(matches(input));
    }

    public static boolean matches(String input) {
        Stack<String> stack = new Stack<>(); // creating new stack
        String lastOpener = ""; //var used to look at the last opener saved
        String[] chars = input.split("");//splits up input string by single characters
        Pattern opener = Pattern.compile("[({\\[]"); //checks regex opening brackets such as ( { and [
        Pattern closer = Pattern.compile("[)}\\]]"); // checks regex closing brackets such as ) } and ]
        for (String aChar : chars) { //iterates over chars array and checks if char matches the regex
            Matcher matcher = opener.matcher(aChar);
            Matcher matcher2 = closer.matcher(aChar);
            if (matcher.matches()) { //if char matches set this char as lastOpener var and put it
                lastOpener = aChar; // into stack
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