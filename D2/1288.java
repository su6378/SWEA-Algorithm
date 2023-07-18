import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {

            long n = Long.parseLong(br.readLine());
            int count = 0; // 숫자 카드
            long k = 0L;
            boolean[] exist = new boolean[10];

            while (count < 10){
                k++;
                long num = n * k;
                StringBuilder sb = new StringBuilder(String.valueOf(num));

                for (int i = 0; i < sb.length(); i++) {
                    if (!exist[Character.getNumericValue(sb.charAt(i))]) {
                        exist[Character.getNumericValue(sb.charAt(i))] = true;
                        count++;
                    }
                }
            }
            bw.write("#"+tc+" "+n*k+"\n");

        }
        bw.flush();
        bw.close();
    }
}