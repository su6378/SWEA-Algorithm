import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());
			
			int[][] arr = new int[N][N];
			
			for (int j = 0; j < arr.length; j++) {
				StringTokenizer arr_token = new StringTokenizer(br.readLine());
				for (int k = 0; k < arr[j].length; k++) {
					int num = Integer.parseInt(arr_token.nextToken());
					arr[j][k] =  num;
				}
			}
			
			int max = 0;
			int sum = 0;
			for (int a = 0; a <= arr.length-M; a++) {
				for (int b = 0; b <= arr[a].length-M; b++) {
					for (int c = a; c < a+M; c++) {
						for (int d = b; d < b+M; d++) {
							sum += arr[c][d];
						}
					}
					if(max < sum) max = sum;
					sum = 0;
				}
				
			}
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(max)+"\n");
			
		}
		bw.flush();
		bw.close();

	}
	
}
