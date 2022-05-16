import java.io.*;
import java.util.Iterator;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			int center = farm.length / 2;

			for (int j = 0; j < N; j++) {
				String str = br.readLine();
				for (int k = 0; k < N; k++) {
					farm[j][k] = Character.getNumericValue(str.charAt(k));
				}
			}

			int top = 0;

			for (int j = 0; j < center; j++) {
				for (int k = center - j; k <= center + j; k++) {
					top += farm[j][k];
				}
			}

			int mid = 0;

			for (int j = 0; j < farm.length; j++) {
				mid += farm[center][j];
			}

			int bottom = 0;
			int idx = 0;
			for (int j = farm.length - 1; j > center; j--) {
				for (int k = center - idx; k <= center + idx; k++) {
					bottom += farm[j][k];
				}
				idx++;
			}
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(top+mid+bottom)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
