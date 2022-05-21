import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			HashMap<Integer,Integer> card = new HashMap<Integer,Integer>();
			for (int i = 1; i <= 9; i++) {
				card.put(i,4);
			}
			card.put(10,16);
			card.put(11,4);
			
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				int pick = Integer.parseInt(br.readLine());
				if(card.containsKey(pick)) card.put(pick,card.get(pick)-1);
				sum += pick;
			}
			
			int big = 22 - sum;
			int A = 0;
			for (int i = big; i <= 11; i++) {
				if(card.containsKey(i)) A += card.get(i);
			}

			int small = 21 - sum;
			int B = 0;
			for (int i = 1; i <= small; i++) {
				if(card.containsKey(i)) B += card.get(i);
			}
			
			bw.write("#"+String.valueOf(tc)+" ");
			if(A >= B) bw.write("STOP\n");
			else bw.write("GAZUA\n");
		}
		bw.flush();
		bw.close();
	}
}
