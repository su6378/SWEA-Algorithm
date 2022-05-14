import java.io.*;
import java.util.*;


public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {

			int[][] sudoku = new int[9][9];

			for (int j = 0; j < 9; j++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				for (int k = 0; k < 9; k++) {
					int num = Integer.parseInt(token.nextToken());
					sudoku[j][k] = num;
				}
			}

			HashMap<Integer, Integer> row = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> col = new HashMap<Integer, Integer>();
			
			int isSudoku = 1;
			for (int j = 0; j < sudoku.length; j++) {
				for (int k = 0; k < sudoku.length; k++) {
					if (col.containsKey(sudoku[j][k])) {
						isSudoku = 0;
						break;
					} else col.put(sudoku[j][k], 1);

					if (row.containsKey(sudoku[k][j])) {
						isSudoku = 0;
						break;
					} else row.put(sudoku[k][j], 1);
				}
				row.clear();
				col.clear();
			}
			
			HashMap<Integer, Integer> rectangle = new HashMap<Integer, Integer>();
			
			if(isSudoku == 1) {
				for (int a = 0; a < sudoku.length; a += 3) {
					for (int b = 0; b < sudoku.length; b += 3) {
						for (int c = a; c < a+3; c++) {
							for (int d = b; d < b+3; d++) {
								if (rectangle.containsKey(sudoku[c][d])) {
									isSudoku = 0;
									break;
								} else rectangle.put(sudoku[c][d], 1);
							}
						}
						rectangle.clear();
					}
				}
				
			}

			bw.write("#"+String.valueOf(i)+" "+String.valueOf(isSudoku)+"\n");

		}

		bw.flush();
		bw.close();

	}

}
