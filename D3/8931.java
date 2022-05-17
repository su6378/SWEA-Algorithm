import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int tc= 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			Stack<Integer> ledger = new Stack<>();
			for (int i = 0; i < K; i++) {
				int num = Integer.parseInt(br.readLine());
				if (num == 0) ledger.pop();
				else ledger.push(num);
			}
			
			int sum = 0;
			
			for (int i = 0; i < ledger.size(); i++) {
				sum += ledger.get(i);
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(sum)+"\n");
		}
		bw.flush();
		bw.close();
	}
}

