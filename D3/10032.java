import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int K = Integer.parseInt(token.nextToken());
			int[] person = new int[K];
			int count = 0;
			
			while (true) {
				
				for (int i = 0; i < person.length; i++) {
					person[i]++;
					count++;
					
					if (count == N) {
						break;
					}
				}
				
				if (count == N) break;
			}
			
			int min = person[0] - person[person.length-1];
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(min)+"\n");
		}
		bw.flush();
		bw.close();
	}
}









