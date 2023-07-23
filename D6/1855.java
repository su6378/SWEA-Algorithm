import java.io.*;
import java.util.*;

class Solution {
    static int n;
    static ArrayList<Integer>[] graph;
    static int[] sequence;
    static int[] depths;
    static int[][] parents;
    static int maxLevel;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());

            graph = new ArrayList[n+1];
            sequence = new int[n + 1];
            depths = new int[n + 1];
            maxLevel = calcMaxLevel(n);
            parents = new int[n + 1][maxLevel];

            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 2; i <= n; i++) {
                int num = Integer.parseInt(st.nextToken());

                parents[i][0] = num;
                graph[num].add(i);
            }

            bfs();

            long move = 0;

            for (int i = 0; i < n - 1; i++) {
                int lca = calcLCA(sequence[i], sequence[i+1]);
                move += (depths[sequence[i]] - depths[lca]) + (depths[sequence[i+1]] - depths[lca]);
            }

            bw.write("#"+tc +" "+move+"\n");

        }
        bw.flush();
        bw.close();
    }

    public static int calcMaxLevel(int n) {
        double log2 = Math.log(n) / Math.log(2);
        return (int) Math.ceil(log2);
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int idx = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            sequence[idx++] = cur; // BFS 방문 순서

            for (int i = 1; i < maxLevel; i++) {
                parents[cur][i] = parents[parents[cur][i - 1]][i - 1];
            }

            for (int next : graph[cur]) {
                depths[next] = depths[cur] + 1;
                q.add(next);
            }
        }
    }

    public static int calcLCA(int node1, int node2) {
        for (int i = maxLevel; i >= 0; i--) {
            if (((depths[node2] - depths[node1]) & 1 << i) > 0) {
                node2 = parents[node2][i];
            }
        }

        if (node2 == node1) return node1;

        for (int i = maxLevel - 1; i >= 0; i--) {
            if (parents[node1][i] != parents[node2][i]){
                node1 = parents[node1][i];
                node2 = parents[node2][i];
            }
        }
        return parents[node1][0];
    }
}