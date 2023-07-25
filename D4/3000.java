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
            int num = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            maxHeap.offer(num);

            int answer = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int num2 = Integer.parseInt(st.nextToken());
                int num3 = Integer.parseInt(st.nextToken());

                if (num2 < num3) {
                    maxHeap.offer(num3);
                    minHeap.offer(num2);
                }else{
                    maxHeap.offer(num2);
                    minHeap.offer(num3);
                }

                if (maxHeap.peek() > minHeap.peek()){
                    int maxPoll = maxHeap.poll();
                    int minPoll = minHeap.poll();

                    maxHeap.offer(minPoll);
                    minHeap.offer(maxPoll);

                    answer += maxHeap.peek();
                    answer %= 20171109;
                }
            }
            bw.write("#"+tc+" "+answer+"\n");
        }
        bw.flush();
        bw.close();
    }
}