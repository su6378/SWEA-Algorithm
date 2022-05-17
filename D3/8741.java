import java.io.*;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc= 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			
			while (token.hasMoreTokens()) {
				String word = token.nextToken();
			
				sb.append(word.toUpperCase().charAt(0));
			}
			
			bw.write("#"+String.valueOf(tc)+" "+sb.toString()+"\n");
			
		}
		bw.flush();
		bw.close();
	}
}


