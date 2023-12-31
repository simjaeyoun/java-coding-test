import java.io.*;
import java.util.*;

public class BJ1764 {

    static int N;
    static int M;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }
        for (int i = 0; i < M; i++) {
            String s = br.readLine();

            if (map.getOrDefault(s, 0) != 0) {
                count++;
                result.add(s);
            }
        }

        System.out.println(count);
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
}
