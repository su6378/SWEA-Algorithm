package Main;

import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(token.nextToken());
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer token2 = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(token2.nextToken());
			int b = Integer.parseInt(token2.nextToken());
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(a/b)+" "+String.valueOf(a%b)+"\n");
			
		}
		bw.flush();
		bw.close();
	}
}

