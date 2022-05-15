package Main;

import java.io.*;
import java.util.*;


class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(token.nextToken());
			int B = Integer.parseInt(token.nextToken());
			
			int hour = 0;
			
			if(A + B >= 24) hour = (A + B) % 24;
			else hour = A + B;
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(hour)+"\n");
			
		}
		bw.flush();
		bw.close();
	}
}

