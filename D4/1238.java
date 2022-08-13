import java.io.*;
import java.util.*;

public class Solution {

	static LinkedList<Integer>[] graph;
	static boolean visited[];
	static ArrayList<Integer> last;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int T = 1; T <= 10; T++) {
			StringTokenizer token = new StringTokenizer(br.readLine());

			int cLength = Integer.parseInt(token.nextToken());
			int start = Integer.parseInt(token.nextToken());

			graph = new LinkedList[101];

			for (int i = 0; i < graph.length; i++) {
				graph[i] = new LinkedList<Integer>();
			}

			token = new StringTokenizer(br.readLine());

			for (int i = 0; i < cLength / 2; i++) {
				
				int from = Integer.parseInt(token.nextToken());
				int to = Integer.parseInt(token.nextToken());

				graph[from].add(to);
			}
			
			visited = new boolean[101];
			last = new ArrayList();
			
			bfs(start);
			
			int max = Integer.MIN_VALUE;
			
			for (Integer i : last) {
				max = Math.max(max,i);
			}
			
			bw.write("#"+String.valueOf(T)+" "+String.valueOf(max)+"\n");
		}

		bw.flush();
		bw.close();
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList();
		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int qSize = queue.size();
			last.clear();

			for (int i = 0; i < qSize; i++) {
				int node = queue.poll();
				last.add(node);

				for (Integer link : graph[node]) {
					if (!visited[link]) {
						visited[link] = true;
						queue.offer(link);
					}
				}
			}
		}
	}
}
