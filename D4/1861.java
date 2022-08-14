import java.awt.Point;
import java.io.*;
import java.util.*;

public class Solution {
	
	static int N;
	static int[][] room;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int count;
	static int max;
	static List<Integer>[] distance;
	static boolean visited[][];
	static boolean checked[];
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tCount = Integer.parseInt(br.readLine());
		
		for (int T = 1; T <= tCount; T++) {
			N = Integer.parseInt(br.readLine());
			
			room = new int[N][N];
			
			
			
			checked = new boolean[(N*N)+1];
			
			distance = new LinkedList[(N*N)+1];
			
			for (int i = 1; i <= (N*N); i++) {
				distance[i] = new LinkedList<Integer>();
			}
			
			
			for (int i = 0; i < room.length; i++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				for (int j = 0; j < room.length; j++) {
					room[i][j] =  Integer.parseInt(token.nextToken());
				}
			}
			
			max = Integer.MIN_VALUE;
			
			for (int i = 0; i < room.length; i++) {
				for (int j = 0; j < room.length; j++) {
					if (!checked[room[i][j]]) {
						visited = new boolean[N][N];
						count = 0;
						bfs(j,i);
						checked[room[i][j]] = true;
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			
			for (int i = 1; i <= N*N; i++) {
				for (Integer node : distance[i]) {
					if (node == max) {
						min = Math.min(min,i);
					}
				}
			}
			
			bw.write("#"+String.valueOf(T)+" "+String.valueOf(min)+" "+String.valueOf(max)+"\n");
		}

		bw.flush();
		bw.close();
	}
	
	static void bfs(int col, int row) {
		Queue<Point> queue = new LinkedList();
		queue.add(new Point(col,row));
		visited[row][col] = true;
		count++;
		
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int x = point.x + dx[i];
				int y = point.y + dy[i];
				
				if (x >= 0 && x < N && y >= 0 && y < N &&!visited[y][x] && room[y][x] == room[point.y][point.x] + 1) {
					visited[y][x] = true;
					queue.add(new Point(x,y));
					checked[room[y][x]] = true; 
					count++;
				}
			}
		
		}
		
		max = Math.max(max,count);
		
		distance[room[row][col]].add(count);
	}

}
