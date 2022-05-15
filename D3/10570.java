import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int i = 1; i <= T; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(token.nextToken());
			int B = Integer.parseInt(token.nextToken());

			int count = 0;

			for (int j = A; j <= B; j++) {
				
				String num = Integer.toString(j);
				StringBuffer sb = new StringBuffer(num);
				String reverse = sb.reverse().toString();
				
				if (num.equals(reverse)) {
					Double sqrt = Math.sqrt(j);
					if (sqrt == sqrt.intValue()) {
						String sqrt_num = Integer.toString(sqrt.intValue());
						StringBuffer sb2 = new StringBuffer(sqrt_num);
						String sqrt_reverse = sb2.reverse().toString();
					
						if (sqrt_num.equals(sqrt_reverse)) count++;
					}
				}
			
			}
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(count)+"\n");
		}

		bw.flush();
		bw.close();
	}
}
