import java.awt.Point;
import java.io.*;
import java.util.*;

public class Solution {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tCount = Integer.parseInt(br.readLine());

		for (int T = 1; T <= tCount; T++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			N = Integer.parseInt(token.nextToken());
			int K = Integer.parseInt(token.nextToken());
			
			map = new int[N][N];
			int highest = Integer.MIN_VALUE;
			
			for (int i = 0; i < map.length; i++) {
				token = new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(token.nextToken());
					highest = Math.max(highest,map[i][j]);
				}
			}
			
			List<Point> start = new LinkedList();
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (map[i][j] == highest ) {
						start.add(new Point(i,j));
					}
				}
			}
			
			max = Integer.MIN_VALUE;
			
			for (int k = 0; k <= K; k++) {
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map.length; j++) {
						if (map[i][j] - k < 0) {
							continue;
						}else {
							map[i][j] -= k; 
						}
						
						for (int s = 0; s < start.size(); s++) {
							hiking(start.get(s).x,start.get(s).y,map);
						}
						
						map[i][j] += k;
					}
				}
			}
			
			
			bw.write("#"+String.valueOf(T)+" "+String.valueOf(max)+"\n");
			
		}

		bw.flush();
		bw.close();
	}
	
	static void hiking(int row, int col,int[][] temp) {
		
		
		int count = 0;
		Queue<Point> queue = new LinkedList();
		queue.add(new Point(col,row));
		
		while (!queue.isEmpty()) {
			int qSize = queue.size();
			count++;
			for (int q = 0; q < qSize; q++) {
				Point point = queue.poll();
				
				for (int i = 0; i < dx.length; i++) {
					int x = point.x + dx[i];
					int y = point.y + dy[i];
					
					if (x >= 0 && x < N && y >= 0 && y < N &&  temp[y][x] < temp[point.y][point.x] ) {
							queue.add(new Point(x,y));
					}
				}
			}
		}
		
		max = Math.max(max,count);
	}

}
