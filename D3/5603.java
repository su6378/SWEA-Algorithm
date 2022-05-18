import java.io.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] hays = new int[N];
			int sum = 0;

			for (int i = 0; i < N; i++) {
				hays[i] = Integer.parseInt(br.readLine());
				sum += hays[i];
			}

			int size = sum / N;
			int move_sum = 0;
			
			for (int i = 0; i < hays.length; i++) {
				 if(hays[i] - size >0)
	                    move_sum += hays[i] - size;
	                else
	                    move_sum += size - hays[i];
			}
			
			
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(move_sum/2)+"");
		}
		bw.flush();
		bw.close();
	}
}
