import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			int[] sale_arr = new int[N];
			
			for (int j = 0; j < N; j++) {
				sale_arr[j] = Integer.parseInt(token.nextToken());
			}
			
			long money = 0;
			int max = 0;
			
			for (int j = N-1; j >= 0 ; j--) {
				if (max < sale_arr[j]) max = sale_arr[j];
				else {
					int num = max - sale_arr[j];
					money += num;
				}
			}
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(money)+"\n");
		}
		bw.flush();
		bw.close();
	}

}
