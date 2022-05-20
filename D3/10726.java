import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());

			String binary = Integer.toBinaryString(M);
			char[] bit = new char[30];
			
			for (int i = 0; i < bit.length; i++) {
				bit[i] = '0';
			}
			
			int idx = 29;
			for (int i = binary.length() - 1; i >= 0.; i--) {
				bit[idx] = binary.charAt(i);
				idx--;
				if (idx < 0)
					break;
			}
			boolean check = true;
			
			for (int i = 30-N; i < bit.length; i++) {
				if (bit[i] == '0') {
					check = false;
					break;
				}
			}
			
			bw.write("#"+String.valueOf(tc)+" ");
			
			if (check) {
				bw.write("ON\n");
			}else bw.write("OFF\n");
		}
		bw.flush();
		bw.close();
	}
}

