import java.io.*;
import java.util.*;

public class Solution {
	
	static List<Integer>[] graph; //인접 리스트
	static boolean[] visited; //중복 체크
	static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());
			
			graph = new ArrayList[N+1];
			
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList();
			}
			
			for (int i = 0; i < M; i++) {
				token = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(token.nextToken());
				int b = Integer.parseInt(token.nextToken());
				
				//인접리스트에 관계 추가 (양방향 관계)
				graph[a].add(b); 
				graph[b].add(a);
			}
			
			count = 0; //마을 갯수
			visited = new boolean[N+1];
			
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) { //방문하지 않았을 때 탐색
					bfs(i);
					count++;
				}
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(count)+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList();
		
		queue.add(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int qPoll = queue.poll();
			
			for (Integer node : graph[qPoll]) {
				if (!visited[node]) { 
					visited[node] = true;
					queue.add(node);
				}
			}
		}
	}
}
