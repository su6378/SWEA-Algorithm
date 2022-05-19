import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());
			String[] winnig_number = new String[N];
	        int[] prize = new int[N];
	       
	        for (int i = 0; i < N; i++) {
				 StringTokenizer token2 = new StringTokenizer(br.readLine());
				winnig_number[i] = token2.nextToken().toString();
				prize[i] = Integer.parseInt(token2.nextToken());
			}
			
			String[] lottery_number = new String[M];
			boolean match = true;
			int sum = 0;
			for (int i = 0; i < lottery_number.length; i++) {
				lottery_number[i] = br.readLine();
				
				for (int j = 0; j < winnig_number.length; j++) {
					for (int k = 0; k < winnig_number[j].length(); k++) {
						if (winnig_number[j].charAt(k) != '*') {
							if(lottery_number[i].charAt(k) != winnig_number[j].charAt(k)) {
								match = false;
								break;
							}
						}
					}
					if(match) sum += prize[j];
					match = true;
				}
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(sum)+"\n");

		}
		bw.flush();
		bw.close();
	}
}




