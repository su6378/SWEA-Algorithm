import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int answer = 0;

            HashMap<String,Integer> map = new HashMap<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                map.put(st.nextToken(),1);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                if (map.containsKey(st.nextToken())) answer++;
            }

            bw.write("#"+tc+" "+answer+"\n");
        }
        bw.flush();
        bw.close();
    }
}