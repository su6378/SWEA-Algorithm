import java.util.*;
class UserSolution {

    class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    ArrayList<ArrayList<Node>> graph;
    ArrayList<ArrayList<Node>> rGraph;
    HashMap<Integer, Integer> map;
    int num = 0;
    final int INF = 1000000000;

    public int init(int N, int sCity[], int eCity[], int mCost[]) {
        graph = new ArrayList<>();
        rGraph = new ArrayList<>();
        map = new HashMap<>();
        num = 0;

        for (int i = 0; i < 1400; i++) {
            graph.add(new ArrayList<>());
            rGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            if (!map.containsKey(sCity[i])) map.put(sCity[i], num++);
            if (!map.containsKey(eCity[i])) map.put(eCity[i], num++);

            int start = map.get(sCity[i]);
            int end = map.get(eCity[i]);

            graph.get(start).add(new Node(end, mCost[i]));
            rGraph.get(end).add(new Node(start, mCost[i]));
        }
        return num;
    }

    public void add(int sCity, int eCity, int mCost) {
        int start = map.get(sCity);
        int end = map.get(eCity);

        graph.get(start).add(new Node(end, mCost));
        rGraph.get(end).add(new Node(start, mCost));
    }

    public int cost(int mHub) {
        return dijkstra(mHub) + rDijkstra(mHub);
    }

    public int dijkstra(int sCity){
        int sum = 0;
        int dist[] = new int[num];
        int start = map.get(sCity);
        boolean[] visited = new boolean[num];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(dist,INF);
        dist[start] = 0;

        pq.add(new Node(start,0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if (visited[cur.end]) continue;
            visited[cur.end] = true;

            for (Node next : graph.get(cur.end)) {
                if (dist[next.end] > next.cost + cur.cost){
                    dist[next.end] = next.cost + cur.cost;
                    pq.add(new Node(next.end,dist[next.end]));
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (i == start) continue;
            sum += dist[i];
        }

        return sum;
    }

    public int rDijkstra(int sCity){
        int sum = 0;
        int dist[] = new int[num];
        int start = map.get(sCity);
        boolean[] visited = new boolean[num];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(dist,INF);
        dist[start] = 0;

        pq.add(new Node(start,0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if (visited[cur.end]) continue;
            visited[cur.end] = true;

            for (Node next : rGraph.get(cur.end)) {
                if (dist[next.end] > next.cost + cur.cost){
                    dist[next.end] = next.cost + cur.cost;
                    pq.add(new Node(next.end,dist[next.end]));
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (i == start) continue;
            sum += dist[i];
        }

        return sum;
    }
}