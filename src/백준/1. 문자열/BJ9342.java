import java.io.*;
import java.util.*;

enum Rule {
    First(new char[] { 'A', 'B', 'C', 'D', 'E', 'F' }, List.of(0, 1)),
    Second(new char[] { 'A' }, List.of(1)),
    Third(new char[] { 'F' }, List.of(1)),
    Forth(new char[] { 'C' }, List.of(1)),
    Fifth(new char[] { 'A', 'B', 'C', 'D', 'E', 'F' }, List.of(0, 1));

    private char[] chars;
    private List<Integer> numbers;

    Rule(char[] chars, List<Integer> numbers) {
        this.chars = chars;
        this.numbers = numbers;
    }

    public int checkingRule(int order, String str) {
        char temp = '0';
        for (char c : chars) {
            if (c == str.charAt(order)) {
                temp = c;
                break;
            }
        }

        if (temp == '0' && !numbers.contains(0)) {
            return -1;
        } else if (temp == '0' && numbers.contains(0)) {
            return order;
        }

        int returnValue = order;
        for (int i = order; i < str.length(); i++) {
            if (str.charAt(i) != temp) {
                returnValue = i;
                break;
            }
        }
        return returnValue;

    }

}

public class BJ9342 {

    static int T;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Rule[] ruleArray = Rule.values();

            String s = br.readLine();
            int offset = 0;
            for (int j = 0; j < ruleArray.length; j++) {
                offset = ruleArray[0].checkingRule(offset, s);
                if (offset == -1) {
                    System.out.println("Good");
                    continue;
                }
            }

            if (offset == s.length() - 1) {
                System.out.println("Infected!");
            }

        }
    }
}
