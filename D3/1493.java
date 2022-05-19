import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer token = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(token.nextToken());
			int Q = Integer.parseInt(token.nextToken());

			int x_point = 1;
			int y_point = 1;
			int y_max = 1;

			int[][] coordinate = new int[300][300];
			for (int i = 1; i <= 41000; i++) {
				coordinate[x_point][y_point] = i;
				x_point++;
				y_point--;

				if (y_point < 1) {
					y_max += 1;
					y_point = y_max;
					x_point = 1;
				}
				
			}

			int x = 0;
			int y = 0;
			int z = 0;
			int w = 0;

			for (int i = 0; i < coordinate.length; i++) {
				for (int j = 0; j < coordinate.length; j++) {
					if (coordinate[i][j] == P) {
						x = i;
						y = j;
					}if (coordinate[i][j] == Q) {
						z = i;
						w = j;
					}

					if (x != 0 && z != 0)
						break;
				}
			}
			
			int p_point = x + z ;
			int q_point = y + w ;

			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(coordinate[p_point][q_point]) + "\n");

		}
		bw.flush();
		bw.close();
	}
}
