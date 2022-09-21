import java.io.*;
import java.util.*;

public class Solution2 {

	static int N;
	static int X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			N = Integer.parseInt(token.nextToken());
			X = Integer.parseInt(token.nextToken());

			int[][] map = new int[N][N];

			for (int i = 0; i < map.length; i++) {
				token = new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(token.nextToken());
				}
			}
			int count = 0;

			for (int i = 0; i < map.length; i++) {
				int[] rowLand = new int[N];
				int[] colLand = new int[N];

				for (int j = 0; j < map.length; j++) {
					rowLand[j] = map[i][j];
					colLand[j] = map[j][i];

				}
				System.out.println(check(rowLand)+" "+i);
				if (check(rowLand))
					count++;
				if (check(colLand))
					count++;

			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(count)+"\n");
		}
		bw.flush();
		bw.close();
	}

	static boolean check(int[] land) { // 올바른 경사로인지 체크
		boolean[][] checked = new boolean[N][N]; // 경사로 체크 배열
		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[i]; j++) {
				checked[N - 1 - j][i] = true;
			}
		}

		int height = land[0];
		int currentX = 0;
		int next = 1;
		boolean[] visited = new boolean[N];
		while (currentX < N - 1) {
			height = land[currentX];
			if (Math.abs(height - land[currentX + 1]) >= 1) {
				if (Math.abs(height - land[currentX + 1]) > 1)
					return false; // 높이가 1이상 차이나면 false
				else {
					if (height > land[currentX + 1]) { // 다음 높이가 더 낮은 경우
						if (currentX + X >= N)
							return false; // X만큼 길이의 경사로가 N을 벗어 났을 때
						else {
							for (int i = currentX + 1; i <= currentX + X; i++) {
								if (!checked[N - height + 1][i] || land[currentX] - land[i] != 1 || visited[i])
									return false; // 밑에 지형이 비어있으면 경사로 X
								visited[i] = true;
							}
							currentX += X;
							continue;
						}
					} else { // 다음 높이가 더 높은 경우
						if (currentX + 1 - X < 0)
							return false;
						else {
							for (int i = currentX + 1 - X; i < currentX; i++) {
								if (!checked[N - height][i] || land[currentX+1] - land[i] != 1 || visited[i])
									return false;
								visited[i] = true;
							}
						}
						currentX++;
						continue;
					}

				}
			}
			currentX++;
			next++;
		}
		
		return true;
	}

}
