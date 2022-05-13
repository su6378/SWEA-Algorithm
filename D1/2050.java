import java.util.*;


import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine().toString();
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			bw.write(String.valueOf(alphabet.indexOf(ch)+1) + " ");
			
		}
		
		
		bw.flush();
		bw.close();

	}

}
