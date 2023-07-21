public class UserSolution {
    
    private static int[][] graph;
    private static boolean[] visited;

    private static int answer;
    public void dfs_init(int N, int[][] path) {
        graph = new int[100][40];

        // 인접행렬
        for (int i = 0; i < N-1; i++) {
            int parent = path[i][0];
            int child = path[i][1];

            int idx = 0;
            while (true){
                if (graph[parent][idx] != 0) idx++;
                else break;
            }

            graph[parent][idx] = child;
        }
    }

    public int dfs(int N) {
        visited = new boolean[100]; // 방문 초기화
        answer = -1;
        dfsRecursive(N,N);
        return answer;
    }

    public void dfsRecursive(int node, int parent){

        visited[node] = true;

        for (int i = 0; i < 40; i++) {
            if (graph[node][i] == 0) break;

            if (graph[node][i] != 0 && !visited[graph[node][i]]){

                if (parent < graph[node][i]) {
                    answer = graph[node][i];
                    return;
                }
                dfsRecursive(graph[node][i],parent);
            }

            if (answer != -1) return;
        }
    }
}