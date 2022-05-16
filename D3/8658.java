import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			int max = 0;
			int min = Integer.MAX_VALUE;
			while (token.hasMoreTokens()) {
				int num = Integer.parseInt(token.nextToken());
				
				int sum = 0;
				
				while (num > 0) {
					sum += num % 10;
					num /= 10;
				}
				
				if (max < sum) max = sum;
				if (min > sum) min = sum;
				
			}
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(max)+" "+String.valueOf(min)+"\n");
		}

		bw.flush();
		bw.close();
	}
}






