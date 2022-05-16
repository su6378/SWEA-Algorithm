import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int i = 1; i <= T; i++) {
			String direction = br.readLine();
			int a = 1;
			int b = 1;
			
			for (int j = 0; j < direction.length(); j++) {
				switch (direction.charAt(j)) {
				case 'L':
					b += a;
					break;

				case 'R':
					a += b;
					break;
				}
			}
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(a)+" "+String.valueOf(b)+"\n");
		}
		bw.flush();
		bw.close();
	}
}