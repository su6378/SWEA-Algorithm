package Main;

import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int i = 1; i <= T; i++) {
			String str = br.readLine();
			StringBuilder sb = new StringBuilder();
			char[] vowel = {'a','e','i','o','u'};
			
			for (int j = 0; j < str.length(); j++) {
				
				if (str.charAt(j) == 'a' || str.charAt(j) == 'e' || str.charAt(j) == 'i' || str.charAt(j) == 'o' || str.charAt(j) =='u') {
					continue;
				}else sb.append(str.charAt(j));
			}
			
			bw.write("#"+String.valueOf(i)+" "+sb.toString()+"\n");
		}
		bw.flush();
		bw.close();
	}
}
