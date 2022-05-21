import java.io.*;
import java.util.StringTokenizer;

class Solution {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(token.nextToken());
			int B = Integer.parseInt(token.nextToken());
			int C = Integer.parseInt(token.nextToken());
			int D = Integer.parseInt(token.nextToken());
			
			double alice = (double)A / (double) B; 
			double bob = (double)C / (double) D;
			
			bw.write("#"+String.valueOf(tc)+" ");
			if(alice > bob) bw.write("ALICE\n");
			else if(alice == bob) bw.write("DRAW\n");
			else bw.write("BOB");
		}
		bw.flush();
		bw.close();
	}
}
