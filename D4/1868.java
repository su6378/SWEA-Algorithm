import java.io.*;

class Solution {
    static int n;
    static char[][] graph;
    static int[][] direction = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());

            graph = new char[n][n];

            for (int i = 0; i < n; i++) {
                String info = br.readLine();
                for (int j = 0; j < n; j++) {
                    graph[i][j] = info.charAt(j);
                }
            }

            bw.write("#" + tc + " " + getMinClickCount() + "\n");
        }
        bw.flush();
        bw.close();
    }

    // 지뢰가 없는 곳을 숫자로 갱신시켜주는 함수
    public static char[][] getMineCountArray() {
        char[][] minCountArr = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minCountArr[i][j] = graph[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (minCountArr[i][j] == '.') minCountArr[i][j] = getMineCount(i, j);
            }
        }

        return minCountArr;
    }

    // 8방향 검색을 통해 지뢰 갯수 갱신시키는 함수
    public static char getMineCount(int r, int c) {
        int count = 0;

        for (int i = 0; i < 8; i++) {
            int nextR = r + direction[i][0];
            int nextC = c + direction[i][1];

            if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && graph[nextR][nextC] == '*') {
                count++;
            }
        }
        return Character.forDigit(count, 10);
    }

    // 클릭 횟숫를 구하는 함수
    public static int getMinClickCount() {
        char[][] mineCountArr = getMineCountArray();
        int count = 0;

        // 숫자가 0인 곳을 클릭하면 연쇄작용이 가장 많이 일어나므로 0인 곳을 클릭
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (mineCountArr[i][j] == '0' && graph[i][j] == '.') {
                    count++;
                    click(mineCountArr, i, j);
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == '.') count++; // 연쇄 작용으로 표시된 숫자를 제외한 . 영역
            }
        }

        return count;
    }

    // 지뢰가 없고 숫자 카운트가 0인 곳을 클릭하는 함수 (DFS)
    public static void click(char[][] mineCountArr, int r, int c) {
        graph[r][c] = mineCountArr[r][c]; // . -> 숫자로 갱신

        for (int i = 0; i < 8; i++) {
            int nextR = r + direction[i][0];
            int nextC = c + direction[i][1];

            if (nextR >= 0 && nextR < graph.length && nextC >= 0 && nextC < graph[0].length) {
                if (graph[nextR][nextC] == '.' && mineCountArr[nextR][nextC] == '0') { // 숫자가 0이면 연새작용
                    click(mineCountArr, nextR, nextC);
                }
                graph[nextR][nextC] = mineCountArr[nextR][nextC];
            }
        }
    }
}