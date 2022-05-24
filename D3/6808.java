import java.io.*;
import java.util.*;

class Solution {
	public static int win;
	public static int lose;
	public static boolean[] g_pick;
	public static boolean[] i_pick;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		for (int tc = 1; tc <= T; tc++) {
			win = 0;
			lose = 0;
			g_pick = new boolean[9];
			i_pick = new boolean[9];
			List<Integer> gyuyoung = new ArrayList<Integer>();
			List<Integer> inyoung = new ArrayList<Integer>();

			for (int i = 1; i <= 18; i++) {
				inyoung.add(i);
			}

			StringTokenizer token = new StringTokenizer(br.readLine());

			for (int i = 0; i < 9; i++) {
				int num = Integer.parseInt(token.nextToken());
				gyuyoung.add(num);
				inyoung.remove(Integer.valueOf(num));
			}

			match(0, gyuyoung, inyoung, 0, 0);

			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(win) + " " + String.valueOf(lose) + "\n");

		}
		bw.flush();
		bw.close();
	}

	static void match(int round, List<Integer> gyuyoung, List<Integer> inyoung, int g_sum, int i_sum) {
		if (round == 9) {
			if (g_sum > i_sum)
				win++;
			else if (g_sum < i_sum)
				lose++;
			g_sum = 0;
			i_sum = 0;
			return;
		} else {
			for (int i = 0; i < 9; i++) {
				if (!g_pick[i]) {
					g_pick[i] = true;
					for (int j = 0; j < g_pick.length; j++) {
						if (!i_pick[j]) {
							i_pick[j] = true;
							int sum = gyuyoung.get(i) + inyoung.get(j);
							if (gyuyoung.get(i) > inyoung.get(j))
								match(round + 1, gyuyoung, inyoung, g_sum + sum, i_sum);

							else if (gyuyoung.get(i) == inyoung.get(j))
								match(round + 1, gyuyoung, inyoung, g_sum, i_sum);

							else
								match(round + 1, gyuyoung, inyoung, g_sum, i_sum + sum);

							i_pick[j] = false;
							break;
						}
					}
					g_pick[i] = false;
				}
			}
		}
	}
}
