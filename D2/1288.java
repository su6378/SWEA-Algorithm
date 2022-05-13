package Main;

import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			
			int num = Integer.parseInt(br.readLine());
			int count = 1;
			Set<Integer> set = new HashSet<Integer>();
			while(true) {
				
				int num2 = num*count;
								
				while(num2 > 0) {
					set.add(num2 % 10);
					num2 /= 10;
				}
				
				if(set.size() == 10) break;
				
				count++;
				
			}
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(count*num)+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}

