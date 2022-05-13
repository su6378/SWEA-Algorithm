package Main;

import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			if(N % i == 0) bw.write(String.valueOf(i)+" ");
		}
		
		bw.flush();
		bw.close();
	}
}

