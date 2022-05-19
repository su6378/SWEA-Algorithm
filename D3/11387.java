import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(token.nextToken());
			int L = Integer.parseInt(token.nextToken());
			int N = Integer.parseInt(token.nextToken());
			double sum = 0;
			
			double l = (double)L/100;
			for (int i = 0; i < N; i++) {
				double damage = (D*(1+i*l));
				sum += damage;
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf((int)sum)+"\n");
		}
		bw.flush();
		bw.close();
	}
}




