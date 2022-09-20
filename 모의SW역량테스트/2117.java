import java.io.*;
import java.util.*;

public class Solution {

	static class Matrix {
		int row;
		int col;

		public Matrix(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}

	static int N;
	static int M;
	static int[][] homes; // 집 정보 이차원 배열
	static List<Matrix> house; // 집의 좌표가 담긴 리스트
	static int max;
	static int homeCount;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());

			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());

			homes = new int[N][N];
			house = new ArrayList<>();
			homeCount = 0; // 집의 개수

			for (int i = 0; i < N; i++) {
				token = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					homes[i][j] = Integer.parseInt(token.nextToken());
					if (homes[i][j] == 1) {
						homeCount++;
						house.add(new Matrix(i, j));
					}
				}
			}

			max = Integer.MIN_VALUE;
			int start = 0; // k서비스 영역 시작
			int count = 1;
			while (true) {
				if (homeCount * M < (count * count) + ((count - 1) * (count - 1))) { // 가장 큰 k 구하기
					start = count - 1;
					break;
				}
				count++;
			}

			for (int i = start; i >= 1; i--) { // start크기부터 서비스 영역 탐색 시작
				if (check(i)) {
					break;
				}
			}

			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(max) + "\n");
		}

		bw.flush();
		bw.close();
	}

	static boolean check(int k) { // k크기의 서비스 영역에 이윤을 얻을 수 있는지 확인
		boolean flag = false;

		for (int i = 0; i < homes.length; i++) {
			for (int j = 0; j < homes.length; j++) {
				int count = getCount(i, j, k);
				if (count > max) {
					if (count * M >= (k * k) + ((k - 1) * (k - 1))) {
						max = count;
						flag = true;
					}
				}
				
				if (count == homeCount) {
					return true;
				}
			}
		}

		return flag;
	}

	static int getCount(int row, int col, int k) { // 서비스 영역에 집 갯수 구하기
		int count = 0;
		int range = 0;
		while (true) {
			if (range == k)
				break;

			if (range == 0) {
				if (homes[row][col] == 1) count++; // 기준 좌표 체크

				for (int i = 1; i < k; i++) {
					if (col + i < N) { // 범위 설정
						if (homes[row][col + i] == 1) count++;
					}

					if (col - i >= 0) {
						if (homes[row][col - i] == 1) count++;
					}
				}
			} else { // 양쪽으로 한칸씩 위아래 탐색 시작
				if (row + range < N) { // 위쪽 행 탐색
					if (homes[row + range][col] == 1)
						count++; // 기준 좌표 체크

					for (int i = 1; i < k - range; i++) {
						if (col + i < N) { // 범위 설정
							if (homes[row + range][col + i] == 1) count++;
						}

						if (col - i >= 0) {
							if (homes[row + range][col - i] == 1) count++;
						}
					}
				}

				if (row - range >= 0) { // 아래쪽 행 탐색

					if (homes[row - range][col] == 1) count++; // 기준 좌표 체크

					for (int i = 1; i < k - range; i++) {
						if (col + i < N) { // 범위 설정
							if (homes[row - range][col + i] == 1) count++;
						}

						if (col - i >= 0) {
							if (homes[row - range][col - i] == 1) count++;
						}
					}
				}

			}
			range++;
		}

		return count;
	}

	static boolean exist(int row, int col) { // 해당 죄표에 집이 있는지 확인
		for (int i = 0; i < house.size(); i++) {
			if (house.get(i).row == row && house.get(i).col == col) {
				return true;
			}
		}
		return false;
	}
}
