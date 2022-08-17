import java.io.*;
import java.util.*;

public class Solution {
	
	static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = Integer.parseInt(br.readLine());

		for (int T = 1; T <= tc; T++) {

			StringTokenizer token = new StringTokenizer(br.readLine());
			int[] prices = new int[4];

			for (int i = 0; i < 4; i++) {
				prices[i] = Integer.parseInt(token.nextToken());
			}

			int[] months = new int[12];
			token = new StringTokenizer(br.readLine());

			boolean isEmpty = true;
			for (int i = 0; i < months.length; i++) {
				months[i] = Integer.parseInt(token.nextToken());
				if (months[i] > 0) {
					isEmpty = false;
				}
			}
			
			min = Integer.MAX_VALUE;

			if (isEmpty) {
				min = 0;
			} else {
				// 하루
				int price = 0;
				for (int i = 0; i < months.length; i++) {
					price += prices[0] * months[i];
				}
				min = Math.min(min, price);

				// 한달
				price = 0;
				for (int i = 0; i < months.length; i++) {
					if (months[i] > 0) {
						price += prices[1];
					}
				}
				min = Math.min(min, price);

				// 3달
				int start = 0;
				price = 0;

				while (true) {
					if (start == 12) {
						break;
					}

					if (months[start] == 0) {
						start++;
					} else {
						if (start + 2 < 12) {
							start += 3;
							price += prices[2];
						} else {
							start = 12;
							price += prices[2];
						}
					}

				}
				min = Math.min(min, price);

				// 1년
				min = Math.min(min, prices[3]);
				
				dfs(0, 0, months, prices);
				
				bw.write("#"+String.valueOf(T)+" "+String.valueOf(min)+"\n");
			}

		}

		bw.flush();
		bw.close();
	}

	static void dfs(int month, int total, int[] months, int[] prices) {
		if (month >= 12) {
			min = Math.min(min, total);
			return;
		}
		if (months[month] == 0) {
			dfs(month + 1, total, months, prices);
		} else {
			dfs(month + 1, total + (prices[0] * months[month]), months, prices);
			dfs(month + 1, total + prices[1], months, prices);
			dfs(month + 3, total + prices[2], months, prices);
		}
	}
}
