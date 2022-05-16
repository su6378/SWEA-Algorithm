package Main;

import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			List<Integer> list = new LinkedList<>();
			
			for (int i = 0; i < 3; i++) {
				int length = Integer.parseInt(token.nextToken()); 
				
				if (list.contains(length)) {
					list.remove(Integer.valueOf(length));
				}else list.add(length);
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(list.get(0))+"\n");
		}
		bw.flush();
		bw.close();
	}
}


