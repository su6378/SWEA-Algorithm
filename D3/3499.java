import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer token = new StringTokenizer(br.readLine());
			String[] card = new String[N];
			
			for (int i = 0; i < N; i++) {
				card[i] = token.nextToken(); 
			}
			int mid = (int)Math.round((((double)card.length /2) * 10) / 10);
			
			bw.write("#"+String.valueOf(tc)+" ");
			
			for (int i = 0; i < mid; i++) {
				bw.write(String.valueOf(card[i])+" ");
				
				if (i+mid > card.length-1) break;
				else bw.write(String.valueOf(card[i+mid])+" ");
			}
			
			bw.write("\n");
			
			
		}
		bw.flush();
		bw.close();
	}
}

