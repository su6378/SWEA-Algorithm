import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {

    static int n, min, size;
    static int[][] matrix;
    static Point cores[];
    static boolean[] checked;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            matrix = new int[n][n];
            cores = new Point[12];
            checked = new boolean[12];
            min = Integer.MAX_VALUE;
            size = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 코어 위치 (가장 자리 코어는 제외)
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (matrix[i][j] == 1) cores[size++] = new Point(j, i);
                }
            }

            for (int i = size; i >= 0; i--) {
                combination(0, 0, i);
                if (min < Integer.MAX_VALUE) break;
            }

            bw.write("#" + tc + " " + min + "\n");
        }
        bw.flush();
        bw.close();
    }

    // 코어 고르기
    public static void combination(int idx, int cnt, int coreCnt) {
        if (cnt == coreCnt) {
            dfs(0,0);
            return;
        }

        for (int i = idx; i < size; i++) {
            checked[i] = true;
            combination(i + 1, cnt + 1, coreCnt);
            checked[i] = false;
        }
    }

    public static void dfs(int idx, int cnt) {
        if (idx == size) {
            min = Math.min(min, cnt);
            return;
        }

        if (!checked[idx]) { // 선택한 코어만 탐색
            dfs(idx + 1, cnt);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int r = cores[idx].y;
            int c = cores[idx].x;
            int sum = 0;
            boolean isSuccess = false;

            while (true) {
                r += dy[i];
                c += dx[i];

                if (r < 0 || r >= n || c < 0 || c >= n) { // 탐색 완료
                    isSuccess = true;
                    break;
                }

                if (matrix[r][c] != 0) break; // 탐색하다가 다른 코어를 만나면 실패
                matrix[r][c] = 2;
                sum++;
            }

            if (isSuccess) dfs(idx + 1, cnt + sum);

            while (true) { // 2로 표시한 전선 정보를 다시 0으로 되돌리기
                r -= dy[i];
                c -= dx[i];
                if (r == cores[idx].y && c == cores[idx].x) break;
                matrix[r][c] = 0;
            }
        }
    }
}