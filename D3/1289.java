package Main;

import java.io.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		for (int i = 1; i <= T; i++) {
			String original_bit = br.readLine(); 
			StringBuilder sb = new StringBuilder();
			
			char original[] = new char[original_bit.length()];
			char[] bit = new char[original_bit.length()];
			for (int j = 0; j < original_bit.length(); j++) {
				original[j] = original_bit.charAt(j); 
				bit[j] = '0'; 
			}
			
			int count = 0;
			for (int j = 0; j < bit.length; j++) {
				if (bit[j] != original_bit.charAt(j)) {
					for (int k = j; k < bit.length; k++) {
						bit[k] = original_bit.charAt(j); 
					}
					count++;
				}else continue;
			}
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(count)+"\n");
		}
		bw.flush();
		bw.close();
	}
}

