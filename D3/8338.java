import java.io.*;
import java.util.StringTokenizer;

class Solution {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer token = new StringTokenizer(br.readLine());
			int result = 0;
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(token.nextToken());
				
				if(i == 0) result += num;
				else {
					if(result * num >= result + num) result *= num;
					else result += num;
				}
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(result)+"\n");
			
			
		}
		bw.flush();
		bw.close();
	}
}
