import java.io.*;
import java.util.Iterator;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		for (int tc= 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			
			for (int i = 0; i < arr.length; i++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = Integer.parseInt(token.nextToken());
				}
			}
			
			int max = 0;
			int row_max = 0;
			int col_max = 0;
			
			for (int i = 0; i < arr.length; i++) {
				int row_sum = 0;
				int col_sum = 0;
				for (int j = 0; j < arr.length; j++) {
					col_sum += arr[i][j];
					row_sum += arr[j][i];
				}
				if (row_max < row_sum) row_max = row_sum;
				if (col_max < col_sum) col_max = col_sum; 
			}
			
			max = Math.max(row_max, col_max);
			
			int diagonal_max = 0;
			int diagonal_sum = 0;
			int diagonal_sum2 = 0;
			for (int i = 0; i < arr.length; i++) {
				diagonal_sum += arr[i][i];
				diagonal_sum2 += arr[arr.length-1-i][i];
			}
			
			max = Math.max(max, Math.max(diagonal_sum, diagonal_sum2));
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(max)+"\n");
			
			
		}
		bw.flush();
		bw.close();
	}
}
