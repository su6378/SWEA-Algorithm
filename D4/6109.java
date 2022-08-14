import java.io.*;
import java.util.*;

public class Solution {

	static int[][] board;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tCount = Integer.parseInt(br.readLine());

		for (int T = 1; T <= tCount; T++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			N = Integer.parseInt(token.nextToken());
			String direction = token.nextToken();

			board = new int[N][N];

			for (int i = 0; i < board.length; i++) {
				token = new StringTokenizer(br.readLine());
				for (int j = 0; j < board.length; j++) {
					board[i][j] = Integer.parseInt(token.nextToken());
				}
			}

			if (direction.equals("up")) {
				up();
			} else if (direction.equals("down")) {
				down();
			} else if (direction.equals("left")) {
				left();
			} else {
				right();
			}
			
			bw.write("#"+String.valueOf(T)+"\n");
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					bw.write(String.valueOf(board[i][j])+" ");
				}
				bw.write("\n");
			}
			
		}

		bw.flush();
		bw.close();
	}

	static void up() {
		boolean[][] checked = new boolean[N][N];

		while (true) {
			boolean finish = true;
			for (int i = 1; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					if (board[i - 1][j] == 0 && board[i][j] != 0) {
						board[i - 1][j] = board[i][j];
						board[i][j] = 0;
						finish = false;

					} else if (board[i][j] != 0 && board[i - 1][j] == board[i][j] && !checked[i - 1][j]
							&& !checked[i][j]) {
						board[i - 1][j] *= 2;
						checked[i - 1][j] = true;
						board[i][j] = 0;
						finish = false;
					}
				}
			}

			if (finish)
				break;

		}

	}

	static void down() {
		boolean[][] checked = new boolean[N][N];

		while (true) {
			boolean finish = true;
			for (int i = board.length - 2; i >= 0; i--) {
				for (int j = 0; j < checked.length; j++) {
					if (board[i + 1][j] == 0 & board[i][j] != 0) {
						board[i + 1][j] = board[i][j];
						board[i][j] = 0;
						finish = false;
					} else if (board[i][j] != 0 && board[i + 1][j] == board[i][j] && !checked[i + 1][j]
							&& !checked[i][j]) {
						board[i + 1][j] *= 2;
						checked[i + 1][j] = true;
						board[i][j] = 0;
						finish = false;
					}
				}
			}

			if (finish)
				break;
		}
	}

	static void left() {
		boolean[][] checked = new boolean[N][N];

		while (true) {
			boolean finish = true;
			for (int i = 1; i < checked.length; i++) {
				for (int j = 0; j < checked.length; j++) {
					if (board[j][i - 1] == 0 && board[j][i] != 0) {
						board[j][i - 1] = board[j][i];
						board[j][i] = 0;
						finish = false;
					} else if (board[j][i] != 0 && board[j][i - 1] == board[j][i] && !checked[j][i - 1]
							&& !checked[j][i]) {
						board[j][i - 1] *= 2;
						checked[j][i - 1] = true;
						board[j][i] = 0;
						finish = false;
					}
				}
			}

			if (finish)
				break;
		}
	}

	static void right() {
		boolean[][] checked = new boolean[N][N];

		while (true) {
			boolean finish = true;
			for (int i = board.length-2; i >= 0; i--) {
				for (int j = 0; j < checked.length; j++) {
					if (board[j][i + 1] == 0 && board[j][i] != 0) {
						board[j][i + 1] = board[j][i];
						board[j][i] = 0;
						finish = false;
					} else if (board[j][i] != 0 && board[j][i + 1] == board[j][i] && !checked[j][i + 1]
							&& !checked[j][i]) {
						board[j][i + 1] *= 2;
						checked[j][i + 1] = true;
						board[j][i] = 0;
						finish = false;
					}
				}
			}

			if (finish)
				break;
		}
	}
}
