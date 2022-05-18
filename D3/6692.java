import java.io.*;
import java.util.StringTokenizer;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int tc = 1; tc <= T; tc++) {
			int N  = Integer.parseInt(br.readLine());
			double salary = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				double p = Double.parseDouble(token.nextToken());
				int x = Integer.parseInt(token.nextToken());
				salary += p * x;
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(salary)+"\n");
			
		}
		bw.flush();
		bw.close();
	}
}

