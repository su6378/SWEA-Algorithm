import java.io.*;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int tc= 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(token.nextToken());
			int A = Integer.parseInt(token.nextToken());
			int B = Integer.parseInt(token.nextToken());
			
			int min = 0;
			int max = 0;
			
			if (N- (A + B) < 0) min = (A + B) - N;
			max = Math.min(A, B);
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(max)+" "+String.valueOf(min)+"\n");
			
			
			
		}
		bw.flush();
		bw.close();
	}
}

