package Main;

import java.io.*;
import java.util.*;


class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 1; i <= 10; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[8];
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(token.nextToken());
			}
			
			int decrease = 1;
			
			while (true) {
				if (arr[arr.length-1] <= 0) break;
				int first = arr[0];
				
				for (int j = 0; j < arr.length; j++) {
					if(j == arr.length-1) {
						arr[j] = first-decrease;
						decrease++;
						if (decrease == 6) decrease = 1;
						if (arr[j] < 0) arr[j] = 0;
					}
					else arr[j] = arr[j+1]; 
				}
			}
			
			bw.write("#"+String.valueOf(i)+" ");
			for (int j = 0; j < arr.length; j++) {
				bw.write(String.valueOf(arr[j]+" "));
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}

