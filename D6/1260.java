import java.io.*;
import java.util.*;

public class Solution3 {

	static class SubMattrix { //화확물질 클래스
		int row;
		int col;
		int size;

		public SubMattrix(int row, int col, int size) {
			super();
			this.row = row;
			this.col = col;
			this.size = size;
		}
	}
	
	static class Pair { // 곱셈 짝 클래스
		int left;
		int right;

		public Pair(int left, int right) {
			super();
			this.left = left;
			this.right = right;
		}
	}
	
	static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());

			int[][] matrix = new int[N][N];
			int[][] rowMatrix = new int[N][N];
			int[][] colMatrix = new int[N][N];
			boolean[][] last = new boolean[N][N]; // 마지막 인덱스 체크

			for (int i = 0; i < matrix.length; i++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				for (int j = 0; j < matrix.length; j++) {
					matrix[i][j] = Integer.parseInt(token.nextToken());
				}
			}

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[i][j] != 0) { // 열 배열 사이즈 정하기
						if (j == 0) {
							colMatrix[i][j] = 1;
						} else {
							if (colMatrix[i][j - 1] != 0) {
								colMatrix[i][j] = colMatrix[i][j - 1] + 1;
							} else {
								colMatrix[i][j] = 1;
							}
						}

						if (i + 1 < N && j + 1 < N) { // 마지막 위치 찾기
							if (matrix[i + 1][j] == 0 && matrix[i][j + 1] == 0) {
								last[i][j] = true;
							}
						} else if (i + 1 < N && j + 1 >= N) {
							if (matrix[i + 1][j] == 0) {
								last[i][j] = true;
							}
						} else if (i + 1 >= N && j + 1 < N) {
							if (matrix[i][j + 1] == 0) {
								last[i][j] = true;
							}
						} else if (i + 1 >= N && j + 1 >= N) {
							last[i][j] = true;
						}
					}

					if (matrix[j][i] != 0) { //행 배열 사이즈 정하기
						if (j == 0) {
							rowMatrix[j][i] = 1;
						} else {
							if (rowMatrix[j - 1][i] != 0) {
								rowMatrix[j][i] = rowMatrix[j - 1][i] + 1;
							} else {
								rowMatrix[j][i] = 1;
							}
						}
					}

				}
			}

			List<SubMattrix> list = new ArrayList();

			for (int i = 0; i < last.length; i++) {
				for (int j = 0; j < last.length; j++) {
					if (last[i][j]) {
						list.add(new SubMattrix(rowMatrix[i][j], colMatrix[i][j], rowMatrix[i][j] * colMatrix[i][j])); // 리스트에 행렬 정보 담아구기
					}
				}
			}

		
			Collections.sort(list, new Comparator<SubMattrix>() { //다중 정렬하기
				int ret = 0;
				@Override
				public int compare(SubMattrix sub1, SubMattrix sub2) {
					if (sub1.size < sub2.size) ret = -1;
					else if (sub1.size > sub2.size) ret = 1;
					else {
						if (sub1.row < sub2.row) ret = -1;	
						else if(sub1.row > sub2.row) ret = 1;
					}
					return ret;
				}
			});
			
			int[] pair = new int[list.size()*2];
			int max = 0;
			
			int index = 0;
			for (int i = 0; i < list.size(); i++) {
				pair[index] = list.get(i).row;
				pair[index+1] = list.get(i).col;
				max = Math.max(max, Math.max(pair[index], pair[index+1]));
				index+=2;
			}
			
			int[] check = new int[max + 1]; //곰셈 왼쪽 오른쪽 배열

			for (int i = 0; i < pair.length; i++) {
				check[pair[i]]++;
			}
			
			List<Pair> pairs = new ArrayList(); 
			
			int target = -1;
			
			
			for (int i = 1; i < check.length; i++) { // 시작 나사 세팅
				if (check[i] == 1) {
					for (int j = 0; j < pair.length; j += 2) {
						if (i == pair[j]) {
							target = pair[j + 1];
							pairs.add(new Pair(pair[j], pair[j + 1]));
						}
					}
				}
			}
			
			int change = 1;

			while (change <= N) { // N만큼 루프
				for (int i = 0; i < pair.length; i += 2) {
					if (pair[i] == target) { //타깃을 찾으면 list에 삽입하고 타깃 갱신
						target = pair[i + 1];
						pairs.add(new Pair(pair[i], pair[i + 1]));
					}
				}
				change++;
			}
			
			List<Integer> powList = new ArrayList();
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(FindSum(pairs))+"\n");
		}
		bw.flush();
		bw.close();
	}
	

	
		public static int FindSum(List<Pair> pairs) { //곱셈 합 구하기(참고했음 다른사람)
			int n = pairs.size();
			int[] D = new int[2 * n + 1];
			int[][] DP = new int[n + 1][n + 1];

			// i의 행, i의 열, j의 열 방식으로 저장
			for (int i = 0; i < n; i++) {
				D[i] = pairs.get(i).left;
				D[i + 1] = pairs.get(i).right;
			}

			// Matrix Chain Multiplication 알고리즘
			for (int len = 2; len <= n; len++) {
				for (int i = 1; i <= n - len + 1; i++) {
					int j = i + len - 1;
					DP[i][j] = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						int weight = DP[i][k] + DP[k + 1][j] + D[i - 1] * D[k] * D[j];
						DP[i][j] = Math.min(DP[i][j], weight);
					}
				}
			}

			return DP[1][n];
		}

}
