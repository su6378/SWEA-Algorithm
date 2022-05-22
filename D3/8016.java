import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			long N = Long.parseLong(br.readLine());
			long max = (N * N * 2) - 1;
			long min = (N - 1) * (N - 1) * 2 + 1;

			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(min) + " " + String.valueOf(max) + "\n");

		}

		bw.flush();
		bw.close();
	}
}
