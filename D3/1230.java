import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());

            List<String> list = new LinkedList<>();

            StringTokenizer token = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                list.add(token.nextToken());
            }

            int m = Integer.parseInt(br.readLine());

            token = new StringTokenizer(br.readLine());

            for (int i = 0; i < m; i++) {
                String state = token.nextToken();

                switch (state) {
                    case "I":
                        int x = Integer.parseInt(token.nextToken());
                        int y = Integer.parseInt(token.nextToken());

                        List<String> temp = new LinkedList<>();

                        for (int j = 0; j < y; j++) {
                            temp.add(token.nextToken());
                        }

                        list.addAll(x, temp);
                        break;

                    case "D":
                        x = Integer.parseInt(token.nextToken());
                        y = Integer.parseInt(token.nextToken());

                        for (int j = 0; j < y; j++) {
                            list.remove(x);
                        }
                        break;

                    case "A":
                        y = Integer.parseInt(token.nextToken());

                        temp = new LinkedList<>();

                        for (int j = 0; j < y; j++) {
                            String s = token.nextToken();
                            temp.add(s);
                        }

                        list.addAll(temp);
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();
            bw.write("#"+tc+" ");

            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i)+" ");
            }

            bw.write(sb+"\n");
        }
        bw.flush();
        bw.close();
    }
}