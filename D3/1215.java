package Main;

import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 1; i <= 10; i++) {
			int N = Integer.parseInt(br.readLine());
			char[][] board = new char[8][8];

			for (int j = 0; j < 8; j++) {
				String str = br.readLine();
				for (int k = 0; k < str.length(); k++) {
					board[j][k] = str.charAt(k);
				}
			}
			int count = 0;
			for (int a = 0; a < board.length; a++) {
				for (int b = 0; b <= board.length - N; b++) {
					StringBuilder sb = new StringBuilder();
					for (int c = b; c < b + N; c++) {
						sb.append(board[a][c]);
					}
					String col = sb.toString();
					StringBuffer bf = new StringBuffer(col);
					String col_reverse = bf.reverse().toString();

					if (col.equals(col_reverse)) {
						count++;
					}
				}
			}
			
			for (int a = 0; a < board.length; a++) {
				for (int b = 0; b <= board.length - N; b++) {
					StringBuilder sb = new StringBuilder();
					for (int c = b; c < b + N; c++) {
						sb.append(board[c][a]);
					}
					String row = sb.toString();
					StringBuffer bf = new StringBuffer(row);
					String row_reverse = bf.reverse().toString();

					if (row.equals(row_reverse)) {
						count++;
					}
				}
			}
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(count)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
