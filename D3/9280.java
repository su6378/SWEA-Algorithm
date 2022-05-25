import java.io.*;
import java.util.*;

class Solution {
	public static boolean[] check;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());
			
			int[] R = new int[N];
			int[] parking = new int[N];
			int money = 0;
			
			for (int i = 0; i < R.length; i++) {
				R[i] = Integer.parseInt(br.readLine());
			}
			
			HashMap<Integer,Integer> W = new HashMap<Integer,Integer>();
			Queue<Integer> waiting = new LinkedList<Integer>();
			
			for (int i = 1; i <= M; i++) {
				W.put(i,Integer.parseInt(br.readLine()));
			}
			
			
			for (int i = 0; i < 2*M; i++) {
				int w = Integer.parseInt(br.readLine());
				
				if(w > 0) {
					boolean full = true;
					for (int j = 0; j < parking.length; j++) {
						if(parking[j] == 0) {
							parking[j] = w;
							full = false;
							break;
						}
					}
					
					if(full) waiting.add(w);
				}
				else {
					int leave = w * -1;
					int index = Integer.MAX_VALUE;
					for (int j = 0; j < parking.length; j++) {
						if(parking[j] == leave)  index = j;
					}
					
					money += R[index] * W.get(leave);
					parking[index] = 0;
					
					if(!waiting.isEmpty()) {
						parking[index] = waiting.poll();
					}
				}
				
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(money)+"\n");
		
		} 
		bw.flush();
		bw.close();
	}
}
