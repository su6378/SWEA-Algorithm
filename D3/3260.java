import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Solution {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			BigInteger A = new BigInteger(token.nextToken());
			BigInteger B = new BigInteger(token.nextToken());
			
			int a = A.intValue();
			int b = B.intValue();
			
			BigInteger result = A.add(B);
			
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(result)+"\n");
			bw.write(String.valueOf(a+b)+"\n");
			
		}
		bw.flush();
		bw.close();
	}
	
}



