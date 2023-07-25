import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int op = Integer.parseInt(st.nextToken());

                switch (op){
                    case 1:
                        int num = Integer.parseInt(st.nextToken());
                        pq.offer(num);
                        break;
                    case 2:
                        if (pq.isEmpty()) sb.append("-1 ");
                        else sb.append(pq.poll()+" ");
                        break;
                }
            }

            bw.write("#"+tc+" "+sb+"\n");

        }
        bw.flush();
        bw.close();
    }
}