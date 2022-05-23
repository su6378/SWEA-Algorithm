import java.io.*;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt((br.readLine().trim()));

			int[][] table = new int[100][100];

			for (int i = 0; i < table.length; i++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				for (int j = 0; j < table[i].length; j++) {
					table[i][j] = Integer.parseInt(token.nextToken());
				}
			}

			int count = 0;

			for (int i = 0; i < table.length; i++) {
				int n_exist = 0;
				for (int j = 0; j < table.length; j++) {
					if (table[j][i] == 1)
						n_exist = 1;
					else if (n_exist == 1 && table[j][i] == 2) {
						count++;
						n_exist = 0;
					}
				}
			}

			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(count) + "\n");

		}
		bw.flush();
		bw.close();
	}
}
