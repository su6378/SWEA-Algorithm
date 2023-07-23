import java.io.*;
import java.util.*;
public class Solution {

    static int n;
    static int[][] graph;
    static int[] parent;
    static int answer;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            graph = new int[m][3];

            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                graph[i][0] = Integer.parseInt(st.nextToken());
                graph[i][1] = Integer.parseInt(st.nextToken());
                graph[i][2] = Integer.parseInt(st.nextToken());
            }

            parent = new int[n+1];
            answer = 0;

            Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2])); // 비용을 기준으로 오름차순 정렬

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < m; i++) {
                if (find(graph[i][0] ) != find(graph[i][1] )) {
                    union(graph[i][0], graph[i][1]);
                    answer += graph[i][2];
                }
            }

            bw.write("#" + tc + " " + answer + "\n");
        }
        bw.flush();
        bw.close();
    }

    // 최소 비용으로 갱신시키기
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b) parent[a] = b;
        else parent[b] = a;
    }

    private static int find(int r) {
        if (parent[r] == r) return r;
        else return find(parent[r]);
    }
}