import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
	
		for (int tc = 1; tc <= T; tc++) {
			long d = Long.parseLong(br.readLine());
			int result = Integer.MAX_VALUE;
			if (d < 100) {
				result = 0;
			}else if(d >= 100 && d < 1000) {
				result = 1;
			}else if(d >= 1000 && d < 10000) {
				result = 2;
			}else if(d >= 10000 && d < 100000) {
				result = 3;
			}else if(d >= 100000 && d < 1000000) {
				result = 4;
			}else {
				result = 5;
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(result)+"\n");
			
			
		}
		bw.flush();
		bw.close();
	}
}


