import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer token = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(token.nextToken()); 
			}
			
			int count = 0;
			
			for (int i = 1; i < arr.length - 1; i++) {
				int max = Math.max(arr[i],Math.max(arr[i-1],arr[i+1]));
				int min = Math.min(arr[i],Math.min(arr[i-1],arr[i+1]));
				
				if (arr[i] != max && arr[i] != min) count++;
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(count)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
