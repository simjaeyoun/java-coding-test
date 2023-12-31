import java.io.*;
import java.util.*;

public class App {
    static Set<String> numbers = new HashSet<>();
    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        boolean[] canUsingNum = new boolean[9];
        Arrays.fill(canUsingNum, true);

        makeNumbers("", canUsingNum);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            compareNumbers(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        }

        System.out.println(numbers.size());

    }

    public static void compareNumbers(String compareNumber, int strike, int ball) {

        List<String> list = new ArrayList<>();

        for (String s : numbers) {
            if (compare(s, compareNumber, strike, ball)) {
                list.add(s);
                // System.out.println(s);
            }
        }
        for (String s : list) {
            numbers.remove(s);
        }
    }

    public static boolean compare(String number, String compareNumber, int strike, int ball) {
        Map<Character, Integer> map = new HashMap<>();

        int i = 1;
        for (Character c : number.toCharArray()) {
            map.put(c, i);
            i++;
        }

        i = 1;
        int compareStrike = 0;
        int compareBall = 0;

        for (Character c : compareNumber.toCharArray()) {
            int order = map.getOrDefault(c, 0);
            if (order == i) {
                compareStrike++;
            } else if (order != 0) {
                compareBall++;
            }

            i++;
        }

        if ((compareBall == ball) && (compareStrike == strike)) {
            return false;
        }

        return true;
    }

    public static void makeNumbers(String number, boolean[] canUsingNum) {
        if (number.length() == 3) {
            numbers.add(number);
            return;
        }
        for (int i = 0; i < canUsingNum.length; i++) {
            if (canUsingNum[i]) {
                int appendNumber = i + 1;
                String num = number + appendNumber;

                canUsingNum[i] = false;
                makeNumbers(num, canUsingNum);
                canUsingNum[i] = true;
            }
        }
    }
    // set만들어서 모든 조합 생성
    // 하나 들어와서 맞지않는거는 set에서 제거
    // 남는거 개수 세기

}
