import java.io.*;
import java.util.*;

public class Solution {
    private static class Node implements Comparable<Node>{
        int left, cnt;

        public Node(int left, int cnt) {
            this.left = left;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node n) {
            if (this.cnt > n.cnt) return 1;
            else if (this.cnt == n.cnt) return 0;

            return -1;
        }
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Node> pq = new PriorityQueue<>();

            pq.offer(new Node(k,0));
            int answer = Integer.MAX_VALUE;

            while (!pq.isEmpty()){
                Node info = pq.poll();

                if (info.left == 0){
                    answer = info.cnt;
                    break;
                }

                pq.offer(new Node(0,info.left + info.cnt));

                for (int i = 0; i < n; i++) {
                    pq.offer(new Node(info.left / a[i], info.left % a[i] + info.cnt));
                }
            }

            bw.write("#"+tc+" "+answer+"\n");
        }
        bw.flush();
        bw.close();
    }
}