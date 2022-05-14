package Main;

import java.io.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());

			int[][] snail = new int[N][N];
			int num = 1;
			int row = 0, col = 0;
			int direction = 1;
			while (num <= N * N) {
				snail[row][col] = num++;

				switch (direction) {
				case 1:
					if(col == N -1 || snail[row][col+1] != 0) {
						direction = 2;
						row++;
					}else col++;
					break;
				case 2:
					if(row == N -1 || snail[row+1][col] !=0) {
						direction = 3;
						col--;
					}else row++;
					break;
				case 3:
					if(col == 0 || snail[row][col-1] != 0 ) {
						direction = 4;
						row--;
					}else col--;
					break;
				case 4:
					if (row== 0 || snail[row-1][col] != 0) {
						direction = 1;
						col++;
					}else row--;
					break;
				}
			}
			
			bw.write("#"+String.valueOf(i)+"\n");
			
			for (int j = 0; j < snail.length; j++) {
				for (int k = 0; k < snail.length; k++) {
					bw.write(String.valueOf(snail[j][k])+" ");
				}
				bw.write("\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
