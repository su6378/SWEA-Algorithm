import java.io.*;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int i = 1; i <= T; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(token.nextToken());
			int B = Integer.parseInt(token.nextToken());
			
			int multiply = 0;
			
			if (A / 10 > 0 || B / 10 > 0){
				multiply = -1;
			}else multiply = A * B;
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(multiply)+"\n");
			
		}
		bw.flush();
		bw.close();
	}
}

