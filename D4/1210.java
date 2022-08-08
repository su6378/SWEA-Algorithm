import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int T = 1; T <= 10; T++) {

			int tNumber = Integer.parseInt(br.readLine());
			int[][] ladders = new int[100][100];
			List<Integer> start = new LinkedList<Integer>();

			for (int i = 0; i < ladders.length; i++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				for (int j = 0; j < ladders.length; j++) {
					int value = Integer.parseInt(token.nextToken());
					if (i == 0) {
						if (value == 1) {
							start.add(j);
						}
					}
					ladders[i][j] = value;
				}
			}

			int answer = -1;

			for (int i = 0; i < start.size(); i++) {
				boolean finish = gameStart(ladders,start.get(i));
				if (finish) {
					answer = start.get(i);
					break;
				}
			}
			
			bw.write("#"+String.valueOf(T)+" "+String.valueOf(answer)+"\n");
		}

		bw.flush();
		bw.close();
	}

	static boolean gameStart(int[][] ladders, int start) {
		boolean isFinsih = false;
		int row = 1;
		int col = start;

		while (true) {
			if (col - 1 >= 0 && ladders[row][col-1] == 1) {
				while(true) {
					if (col - 1 >= 0 && ladders[row][col-1] == 1) {
						col--;
					}else {
						break;
					}
				}
			}else if (col + 1 <= 99 && ladders[row][col+1] == 1) {
				while (true) {
					if (col + 1 <= 99 && ladders[row][col+1] == 1) {
						col++;
					}else {
						break;
					}
				}
			}
			
			row++;
			
			if (row == 99) {
				break;
			}
		}
		
		if (ladders[row][col] == 2) {
			isFinsih = true;
		}
				
		return isFinsih;
	}
}