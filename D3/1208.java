import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		for (int tc= 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer token = new StringTokenizer(br.readLine());
			int[] dump = new int[100];
			
			for (int i = 0; i < dump.length; i++) {
				dump[i] = Integer.parseInt(token.nextToken()); 
			}
			
			Arrays.sort(dump);
			int max = 0;
			int min = 0;
			
			for (int i = 0; i < N; i++) {
				dump[0] += 1;
				dump[dump.length-1] -= 1;
				Arrays.sort(dump);
			}
			
			int height = dump[dump.length-1] - dump[0];
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(height)+"\n");
			
		}
		bw.flush();
		bw.close();
	}
}


