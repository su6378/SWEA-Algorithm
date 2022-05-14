import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];

			for (int j = 0; j < arr.length; j++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				for (int k = 0; k < arr[j].length; k++) {
					int num = Integer.parseInt(token.nextToken());
					arr[j][k] = num;
				}
			}

			int[][] arr_90 = new int[N][N];

			for (int j = 0; j < arr.length; j++) {
				int row_idx = arr.length - 1;
				for (int k = 0; k < arr.length; k++) {
					arr_90[j][k] = arr[row_idx--][j];
				}
			}

			int[][] arr_180 = new int[N][N];

			for (int j = 0; j < arr.length; j++) {
				int row_idx = arr.length - 1 - j;
				int col_idx = arr.length - 1;
				for (int k = 0; k < arr.length; k++) {
					arr_180[j][k] = arr[row_idx][col_idx--];
				}
			}
			
			int[][] arr_270 = new int[N][N];

			for (int j = 0; j < arr.length; j++) {
				int col_idx = arr.length - 1 - j;
				for (int k = 0; k < arr.length; k++) {
					arr_270[j][k] = arr[k][col_idx];
				}
			}
			
			bw.write("#"+String.valueOf(i)+"\n");
			
			for (int a = 0; a < arr.length; a++) {
				for (int b = 0; b < arr[a].length; b++) {
					bw.write(String.valueOf(arr_90[a][b]));
				}
				bw.write(" ");
				for (int b = 0; b < arr[a].length; b++) {
					bw.write(String.valueOf(arr_180[a][b]));
				}
				bw.write(" ");
				for (int b = 0; b < arr[a].length; b++) {
					bw.write(String.valueOf(arr_270[a][b]));
				}
				bw.write("\n");
			}
		}

		bw.flush();
		bw.close();

	}
}
