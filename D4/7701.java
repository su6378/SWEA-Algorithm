import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() < o2.length()){
                        return -1;
                    }else if (o1.length() == o2.length()){
                       return o1.compareTo(o2);
                    }else return 1;
                }
            });

            for (int i = 0; i < n; i++) {
                String name = br.readLine();

                if (!map.containsKey(name)) {
                    map.put(name, 1);
                    pq.offer(name);
                }
            }

            bw.write("#"+tc+"\n");

            while (!pq.isEmpty()){
                bw.write(pq.poll()+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}