import java.io.*;

class Solution {
	public static int N;
	public static int count;
	public static int[] board;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			board = new int[N];
			count = 0;

			if (N == 1)
				count = 1;
			else if (N == 2 || N == 3)
				count = 0;
			else {
				dfs(0);
			}

			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(count) + "\n");

		}
		bw.flush();
		bw.close();

	}

	static void dfs(int k) {
		if (k == N) count++;
		else {
			for (int i = 0; i < N; i++) {
				board[k] = i;
				if (check(k)) dfs(k + 1);	
			}
		}
	}

	static boolean check(int row) {
		for (int i = 0; i < row; i++) {
			if (board[i] == board[row] || Math.abs(board[row] - board[i]) == Math.abs(row - i))
				return false;
		}
		return true;
	}
}
