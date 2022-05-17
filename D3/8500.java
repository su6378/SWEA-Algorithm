import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc= 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			List<Integer> seat = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				seat.add(Integer.parseInt(token.nextToken())); 
			}
			
			Collections.sort(seat,Collections.reverseOrder());
			
			int min = 0;
			
			for (int i = 0; i < seat.size(); i++) {
				if (i == 0) min += (seat.get(i) * 2) + 1;
				else min += seat.get(i) + 1;
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(min)+"\n");
		}
		bw.flush();
		bw.close();
	}
}

