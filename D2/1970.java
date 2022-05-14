import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer token = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(token.nextToken());
		
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] s_market = {50000,10000,5000,1000,500,100,50,10};
			
			bw.write("#"+String.valueOf(i)+"\n");
			for (int j = 0; j < s_market.length; j++) {
				int count = 0;
				
				if(N == 0) bw.write("0 ");
				else {
					if(N / s_market[j] > 0) {
						count = N / s_market[j];
						N %= s_market[j];
					}
					bw.write(String.valueOf(count)+" ");
				}
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();

	}

}
