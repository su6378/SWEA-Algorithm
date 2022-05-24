import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		for (int tc = 1; tc <= T; tc++) {
			Queue<Integer> blue = new LinkedList<Integer>();
			Queue<Integer> orange = new LinkedList<Integer>();
			Queue<Character> order = new LinkedList<Character>();
			
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(token.nextToken());
			
			for (int i = 0; i < N; i++) {
				char robot = token.nextToken().charAt(0);
				order.add(robot);
				if(robot == 'B') blue.add(Integer.parseInt(token.nextToken()));
				else orange.add(Integer.parseInt(token.nextToken()));
			}
			
			int time = 0;
			int b_idx = 1;
			int o_idx = 1;
			boolean isPoll = true;
			while(true) {
				
				if(blue.isEmpty() && orange.isEmpty()) break;
				
				time++;
				
				if(!blue.isEmpty()) {
					if(b_idx < blue.peek()) b_idx++;
					else if(b_idx == blue.peek()) {
						if(order.peek() == 'B' && isPoll == true) {
							blue.poll();
							order.poll();
							isPoll = false;
						}
						
					}
					else b_idx--;
				}
			
				
				if(!orange.isEmpty()) {
					if(o_idx < orange.peek()) o_idx++;
					else if(o_idx == orange.peek()) {
						if(order.peek() == 'O' && isPoll == true) {
							orange.poll();
							order.poll();
							isPoll = false;
						}
						
					}
					else o_idx--;
				}
				
				isPoll = true;
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(time)+"\n");
			

		}
		bw.flush();
		bw.close();
	}
}
