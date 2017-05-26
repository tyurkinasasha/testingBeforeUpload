package practice.cipher;

import java.util.HashMap;
import java.util.Map;

public class CaesarCipher {
    private Map<Character, Integer> alph = new HashMap<>();
    private Map<Integer, Character> shAlph = new HashMap<>();
    private Map<Integer, Character> alph2 = new HashMap<>();
    private Map<Character, Integer> shAlph2 = new HashMap<>();

    public CaesarCipher(int shift) {
        fillAlphabet(shift);
    }

    public String decode(String s) {
        StringBuilder sb = new StringBuilder();
        char[] inChar = s.toCharArray();
        for (char c : inChar) {
            if (c == ' ') {
                sb.append(" ");
                continue;
            }
            sb.append(alph2.get(shAlph2.get(c)));
        }
        return sb.toString();
    }

    public String encode(String s) {
        StringBuilder sb = new StringBuilder();
        char[] inChar = s.toCharArray();
        for (char c : inChar) {
            if (c == ' ') {
                sb.append(" ");
                continue;
            }
            sb.append(shAlph.get(alph.get(c)));
        }
        return sb.toString();
    }

    private void fillAlphabet(int shift) {
        int counter = 0;
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            alph.put(ch, counter);
            alph2.put(counter, ch);
            counter++;
        }
        counter = 0;
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            shAlph2.put(ch, (counter + shift) % 26);
            shAlph.put((counter + shift) % 26, ch);
            counter++;
        }
    }
}