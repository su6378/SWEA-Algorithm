import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            List<Integer> sequence = new LinkedList<>();

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                sequence.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                switch (command){
                    case "I" :
                        int idx = Integer.parseInt(st.nextToken());
                        sequence.add(idx,Integer.parseInt(st.nextToken()));
                        break;
                    case "D":
                        idx = Integer.parseInt(st.nextToken());
                        sequence.remove(idx);
                        break;
                    case "C":
                        idx = Integer.parseInt(st.nextToken());
                        sequence.add(idx,Integer.parseInt(st.nextToken()));
                        sequence.remove(idx+1);
                        break;
                }
            }

            if (l > sequence.size()-1) bw.write("#"+tc+" -1\n");
            else bw.write("#"+tc+" "+sequence.get(l)+"\n");

        }
        bw.flush();
        bw.close();
    }
}