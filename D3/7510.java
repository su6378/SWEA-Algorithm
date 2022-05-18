import java.io.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int count = 0;
			boolean check = true;
			if (N == 1) {
				count = 1;
			}else {
				while(check) {
					for (int i = 1; i <= N; i++) {
						int sum = 0;
						for (int j = i; j <= N; j++) {
							sum += j;
							if (sum == N) {
								count++;
								break;
							}
							if (sum > N) break;
						}
					}
					check = false;
				}
				
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(count)+"\n");
		}
		bw.flush();
		bw.close();
	}
} 

