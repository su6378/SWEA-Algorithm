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
            int k = Integer.parseInt(st.nextToken());

            int[][] items = new int[n + 1][2];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                items[i][0] = Integer.parseInt(st.nextToken());
                items[i][1] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[n + 1][k + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    // 해당 위치에 물건을 넣을 수 없는 경우
                    if (items[i][0] > j) dp[i][j] = dp[i - 1][j];
                    else { // 물건을 넣을 수 있는 경우
                        // i - 1번째 물건까지 고려했을때 무게 j에서의 최대 가치(최적해) -> dp[i-1][j]
                        // i - 1번째 물건까지 고려했을때 무게 j - items[i][0](현재 무게)의 최대 가치(최적해) + items[i][1](현재 가치)
                        // -> dp[i-1][j-items[i][0]] + items[i][1] 중에서 큰 값을 선택
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i][0]] + items[i][1]);
                    }
                }
            }

            bw.write("#" + tc + " " + dp[n][k] + "\n");

        }
        bw.flush();
        bw.close();
    }
}