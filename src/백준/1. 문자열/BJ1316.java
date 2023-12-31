
import java.io.*;
import java.util.*;

public class BJ1316 {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        // st = new StringTokenizer(br.readLine());
        // int n = Integer.parseInt(st.nextToken());

        String[] strs = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = br.readLine();
        }

        int count = 0;
        for (String s : strs) {
            Map<Integer, Integer> map = new HashMap<>();

            int previousKey = -1;
            boolean countable = true;

            for (int i : s.chars().toArray()) {
                if (map.getOrDefault(i, 0) != 0 && previousKey != i) {
                    countable = false;
                    break;
                }

                map.put(i, map.getOrDefault(i, 0) + 1);
                previousKey = i;
            }

            if (countable) {
                count++;
            }

        }

        System.out.println(count);
    }
}
