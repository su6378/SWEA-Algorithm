import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		int max = 1000000;
		boolean[] prime = new boolean[max+1];
		prime[0] = true;
		prime[1] = true;
		
		for (int i = 2; i * i <= max ; i++) {
			if(!prime[i]) {
				for(int j = i * i; j <= max; j+=i) prime[j] = true; 
			}
		}
		
		ArrayList<Integer> prime_number = new ArrayList<Integer>();
		
		for (int i = 1; i <= max; i++) {
			if(!prime[i]) prime_number.add(i);
		}
		

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(token.nextToken());
			int A = Integer.parseInt(token.nextToken());
			int B = Integer.parseInt(token.nextToken());
			
			List<Integer> d_list = new ArrayList<Integer>();
			
			int count = 0;

			for (int i = A; i <= B; i++) {
				if(!prime[i]) d_list.add(i);
			}
			
			for (int i = 0; i < d_list.size(); i++) {
				int num = d_list.get(i);
				while(num != 0) {
					int d = num % 10;
					num /= 10;
					if(d == D) {
						count++;
						break;
					}
				}
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(count)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
