package Main;

import java.io.*;
import java.util.*;


class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			String str = br.readLine();
			String decode = new String(Base64.getDecoder().decode(str));
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(decode)+"\n");
		}
		
		
		
		bw.flush();
		bw.close();
	}
}

