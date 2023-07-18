import java.io.*;

class Solution {

    static int[][] dp;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());


        for (int tc = 1; tc <= t; tc++) {
            String managers = br.readLine();
            dp = new int[managers.length() + 1][16];

            for (int i = 1; i < 16; i++) { // 1일차 값 넣어주기
                if ((i & 1) == 0) continue; // 책임자가 없으면 패스

                if ((i & (1 << managers.charAt(0) - 'A')) == 0) continue; // 책임자가 있더라도 A가 없으면 패스

                dp[0][i] = 1;
            }

            for (int i = 1; i < managers.length(); i++) {
                for (int j = 1; j < 16; j++) {
                    for (int k = 1; k < 16; k++) {

                        if ((j & (1 << managers.charAt(i) - 'A')) == 0) continue; // 책임자가 포함되는지 체크

                        if ((j&k) == 0) continue; // 이전에 참석한 사람이 없는 경우

                        dp[i][j] += dp[i-1][k];
                        dp[i][j] %= 1000000007;
                    }
                }
            }

            int answer = 0;

            for (int i = 1; i < 16; i++) {
                answer += dp[managers.length()-1][i];
                answer %= 1000000007;
            }

            bw.write("#"+tc+" "+answer+"\n");
        }
        bw.flush();
        bw.close();
    }
}