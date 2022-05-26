import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[] wave = new long[100];
		
		wave[0] = 1;
		wave[1] = 1;
		wave[2] = 1;
		
		for (int i = 3; i < wave.length; i++) {
			wave[i] = wave[i-3] + wave[i-2]; 
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(wave[N-1])+"\n");
			
			

		}
		bw.flush();
		bw.close();
	}

}
