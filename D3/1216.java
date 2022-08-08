import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int T = 1; T <= 10; T++) {
			int tNumber = Integer.parseInt(br.readLine());
			int targetLength = 100;
			char[][] board = new char[100][100];
			
			int count = 0;

			for (int i = 0; i < board.length; i++) {
				String str = br.readLine();
				for (int j = 0; j < board.length; j++) {
					board[i][j] = str.charAt(j); 
				}
				
			}
			
			boolean find = false;
			
			while (!find) {
				for (int i = 0; i < board.length; i++) { // 행 검색
					for (int j = 0; j <= board.length - targetLength; j++) {
						StringBuffer sb = new StringBuffer();
						for (int k = j; k < j + targetLength; k++) {
							sb.append(board[i][k]);
						}

						String str = sb.toString();
						String reverse = sb.reverse().toString();

						if (str.equals(reverse)) {
							count = str.length();
							find = true;
						}
					}
				}
				
				for (int i = 0; i < board.length; i++) {
					for (int j = 0; j <= board.length - targetLength; j++) {
						StringBuffer sb = new StringBuffer();
						for (int k = j; k < j + targetLength; k++) {
							sb.append(board[k][i]);
						}

						String str = sb.toString();
						String reverse = sb.reverse().toString();

						if (str.equals(reverse)) {
							count = str.length();
							find = true;
						}
					}
				}
				
				if (find) {
					break;
				} else {
					targetLength--;
				}

			}

			bw.write("#" + String.valueOf(T) + " " + String.valueOf(count) + "\n");
		}

		bw.flush();
		bw.close();
	}
}
