import java.io.*;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());

            String binaryM = Integer.toBinaryString(m);

            if (binaryM.length() < n) bw.write("#"+tc+" "+"OFF\n"); // 마지막 N 비트보다 이진수의 길이가 적으면 OFF
            else{
                String num = binaryM.substring(binaryM.length() - n);
                if (Integer.parseInt(num,2) == (int)Math.pow(2.0,n)-1) bw.write("#"+tc+" "+"ON\n");
                else bw.write("#"+tc+" "+"OFF\n");
            }
        }
        bw.flush();
        bw.close();
    }
}