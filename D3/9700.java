import java.io.*;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc= 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			double p = Double.parseDouble(token.nextToken());
			double q = Double.parseDouble(token.nextToken());
			
			double s1 = (1-p) * q;
			double s2 = p * (1-q) * q;
			
			if (s1 < s2) bw.write("#"+String.valueOf(tc)+" YES\n");
			else bw.write("#"+String.valueOf(tc)+" NO\n");
		}
		bw.flush();
		bw.close();
	}
}




