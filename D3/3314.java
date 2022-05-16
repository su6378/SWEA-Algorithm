import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			int sum = 0;
			while (token.hasMoreTokens()) {
				int score = Integer.parseInt(token.nextToken());
				if (score < 40) score = 40;
				sum += score;
			}
			
			int average = sum / 5;
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(average)+"\n");
		}
		bw.flush();
		bw.close();
	}
}







