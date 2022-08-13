import java.awt.Point;
import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int[][] matrix;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int T = 1; T <= 10; T++) {
			int tc = Integer.parseInt(br.readLine());
			
			matrix = new int[16][16];
			visited = new boolean[16][16];
			int startX = -1;
			int startY = -1;
			
			for (int i = 0; i < matrix.length; i++) {
				String arr = br.readLine();
				for (int j = 0; j < arr.length(); j++) {
					char number = arr.charAt(j);
					matrix[i][j] = Character.getNumericValue(number);
					
					if (matrix[i][j] == 2) {
						startX = j;
						startY = i;
					}
				}
			}
			
			
			boolean answer = bfs(startX,startY);
			
			if (answer) {
				bw.write("#"+String.valueOf(T)+" 1\n");
			}else {
				bw.write("#"+String.valueOf(T)+" 0\n");
			}
		}

		bw.flush();
		bw.close();
	}
	
	static boolean bfs(int startX, int startY) {
		
		boolean isComplete = false;
		
		Queue<Point> queue = new LinkedList();
		queue.add(new Point(startX,startY));
		visited[startX][startY] = true;
		
		while (!queue.isEmpty()) {
			int qSize = queue.size();
			
			for (int i = 0; i < qSize; i++) {
				Point point = queue.poll();
				
				if (matrix[point.x][point.y] == 3) {
					isComplete = true;
					return isComplete;
				}
				
				for (int j = 0; j < dx.length; j++) {
					int x = point.x + dx[j];
					int y = point.y + dy[j];
			
					
					if (x >= 0 && x < 16 && y >= 0 && y < 16 && !visited[y][x] && matrix[y][x] != 1) {
						
						if (matrix[y][x] == 3) {
							isComplete = true;
							return isComplete;
						}else {
							visited[y][x] = true;
							queue.offer(new Point(x,y));
						}
					}
				}
			}
		}
		return isComplete;
	}
}
