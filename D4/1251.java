import java.awt.Point;
import java.io.*;
import java.util.*;

public class Solution {
	
	static class Node implements Comparable<Node>{ //우선순위 큐 구햔
		int no; //연결된 정점
		long w; //비용
		
		public Node(int no, long w) {
			this.no = no;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.w, o.w);
		}
	}
	
	static boolean[] visited; //방문 체크
	static double E; 
	static long sum; //환경부담금 합
	static List<Node>[] weight; //해당 점 위치에 연결된 정점과 비용을 알 수 있는 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			Point[] islands = new Point[N]; //섬 좌표 배열
			
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) { //x좌표
				islands[i] = new Point(); //섬 갯수 만큼 생성
				islands[i].x = Integer.parseInt(token.nextToken());
			}
			
			token = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) { //y좌표
				islands[i].y = Integer.parseInt(token.nextToken());
			}
			
			weight = new ArrayList[N];
			
			for (int i = 0; i < N; i++) {
				weight[i] = new ArrayList();
				
				for (int j = 0; j < N; j++) {
					if (i != j) {
						long distanceX = Math.abs(islands[i].x - islands[j].x);
						long distanceY = Math.abs(islands[i].y - islands[j].y);
						weight[i].add(new Node(j,distanceX * distanceX +distanceY * distanceY));
					}
				}
			}
			
			E = Double.parseDouble(br.readLine());
			sum = 0;
			visited = new boolean[N];
			
			bfs();
			long charge = Math.round(sum * E); //소수 첫째자리에서 반올림
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(charge)+"\n");
			
		}
		bw.flush();
		bw.close();
	}
	
	static void bfs() {
		PriorityQueue<Node> queue = new PriorityQueue();
		queue.add(new Node(0,0));
		int count = 0;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			if (!visited[node.no]) { //방문하지 않은 정점만 체크
				sum += node.w;
				visited[node.no] = true;
				count++;
				
				
				for (int i = 0; i < weight[node.no].size(); i++) { //해당 정점의 간선 비용들을 참색
					Node visit = weight[node.no].get(i);
					if (!visited[visit.no]) { //방문 체크(비용이 작은 순서대로 탐색하기 때문에 가장 적은 비용의 가중치를 가진 정점이 add)
						queue.add(visit);
					}
				}
				
			}
			
		}
		
	}
	
}
