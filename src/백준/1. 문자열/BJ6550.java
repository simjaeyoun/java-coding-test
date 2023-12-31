import java.io.*;
import java.util.*;

public class BJ6550 {

    // static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N = Integer.parseInt(br.readLine());
        // st = new StringTokenizer(br.readLine());
        // int n = Integer.parseInt(st.nextToken());

        String s;

        while ((s = br.readLine()) != null) {
            st = new StringTokenizer(s);

            int[] S = st.nextToken().chars().toArray();
            int[] T = st.nextToken().chars().toArray();

            int size = T.length;
            int j = 0;

            for (int i = 0; i < size; i++) {
                if (T[i] == S[j]) {
                    j++;
                }
                if (j == S.length) {
                    break;
                }
            }
            if (j == S.length) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }

    }
}
