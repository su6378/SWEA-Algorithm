import java.io.*;
import java.util.*;

public class Solution {

	static class SubMattrix {
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

					if (matrix[j][i] != 0) {
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
			
//			for (SubMattrix subMattrix : list) {
//				System.out.println(subMattrix.row + " " + subMattrix.col + " " + subMattrix.size);
//			}
//			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(list.size()+" "));
			for (SubMattrix subMattrix : list) {
				bw.write(String.valueOf(subMattrix.row)+" "+String.valueOf(subMattrix.col)+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
