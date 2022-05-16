import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int matches = (int) Math.pow(2, N);
			
			Queue<Integer> person_list = new LinkedList<Integer>();
			StringTokenizer token = new StringTokenizer(br.readLine());
			while(token.hasMoreTokens()) person_list.add(Integer.parseInt(token.nextToken()));
		
			int boring = 0;
			
		
			while(person_list.size() >= 2) {
				int p1 = person_list.poll();
				int p2 = person_list.poll();
				
				boring += Math.abs(p1-p2);
				
				if(p1 > p2) person_list.add(p1);
				else person_list.add(p2);
				
			}
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(boring)+'\n');
		}

		bw.flush();
		bw.close();
	}
}



