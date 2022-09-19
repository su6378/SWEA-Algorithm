import java.io.*;
import java.util.*;


public class Solution {

	static List<Integer>[] graph; //인접 리스트
	static boolean[] visited; //중복 체크
	static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			
			graph = new ArrayList[N+1];
			
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList();
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (Integer.parseInt(token.nextToken()) == 1) { //1이면 연결된 것이기 때문에 인접리스트에 추가
						graph[i].add(j);
					}
				}
			}
			min = Integer.MAX_VALUE;
			
			for (int i = 1; i <= N; i++) { //탐색 시작
				visited = new boolean[N+1];
				bfs(i);
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(min)+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList();
		
		queue.add(start);
		visited[start] = true;
		
		int count = 1;
		int distance = 0;
		
		while (!queue.isEmpty()) {
			int qSize = queue.size();
			
			for (int i = 0; i < qSize; i++) {
				int qPoll = queue.poll();
				
				for (Integer node : graph[qPoll]) {
					if (!visited[node]) {
						visited[node] = true;
						queue.add(node);
						distance += count;
					}
				}
			}
			
			if (distance >= min) { //최솟값보다 클 경우 백트래킹
				return;
			}
			
			count++;
		}
		
		min = Math.min(min,distance);
		
	}
}
