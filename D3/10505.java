package Main;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int sum = 0;
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < arr.length; j++) {
				int num = Integer.parseInt(token.nextToken());
				arr[j] = num;
				sum += num;
			}
			
			int average = sum / N;
			int count = 0;
			
			for (int j = 0; j < arr.length; j++) {
				if(arr[j] <= average) count++;
			}
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(count)+"\n");
		}
		bw.flush();
		bw.close();
	}
}

