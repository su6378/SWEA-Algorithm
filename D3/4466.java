import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int tc= 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int K = Integer.parseInt(token.nextToken());
			List<Integer> score = new ArrayList<>();
			StringTokenizer token2 = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				score.add(Integer.parseInt(token2.nextToken()));
			}
			
			Collections.sort(score,Collections.reverseOrder());
			int sum = 0;
			
			for (int i = 0; i < K; i++) {
				sum += score.get(i);
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(sum)+"\n");
			
		}
		bw.flush();
		bw.close();
	}
}