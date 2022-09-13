import java.awt.Point;
import java.io.*;
import java.util.*;

public class Solution {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] sumArr;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String row = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = Character.getNumericValue(row.charAt(j));
				}
			}

			visited = new boolean[N][N];
			min = Integer.MAX_VALUE;
			sumArr = new int[N][N];
			
			for (int i = 0; i < N; i++) { //일단 최대값으로 넣어주기
				for (int j = 0; j < N; j++) {
					sumArr[i][j] = Integer.MAX_VALUE;
				}
			}
			
			sumArr[0][0] = 0;
			move(0,0);
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(min)+"\n");
		}
		bw.flush();
		bw.close();
	}

	static void move(int row, int col) {

		Queue<Point> queue = new LinkedList();
		queue.add(new Point(col, row));
		visited[row][col] = true;

		while (!queue.isEmpty()) {
			Point point = queue.poll();

			if (point.x == N - 1 && point.y == N - 1) { //최솟값 갱신
				min = Math.min(min, sumArr[point.y][point.x]);
			}
			
			if (min <= sumArr[point.y][point.x]) { //현재 최소값보다 클 경우 pass
				continue;
			}

			for (int i = 0; i < dx.length; i++) { //방향벡터 이동
				int x = point.x + dx[i];
				int y = point.y + dy[i];

				if (x >= 0 && x < N && y >= 0 && y < N ) { // 0 ~ N-1사이
					if (!visited[y][x] || sumArr[point.y][point.x] + map[y][x] < sumArr[y][x]) { //첫 방문이거나 방문했을 때 sum값이 기존의 값보다 작은 경우 갱신
						visited[y][x] = true;
						sumArr[y][x] = sumArr[point.y][point.x] + map[y][x];
						queue.add(new Point(x,y));
					}
				}
			}
		}
	}
}
