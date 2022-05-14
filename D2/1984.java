import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer token = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(token.nextToken());
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer token2 = new StringTokenizer(br.readLine());
			int[] arr = new int[10];
			int max = 0;
			int min = 10001;
			
			for (int j = 0; j < 10; j++) {
				int num = Integer.parseInt(token2.nextToken());
				if(min > num) min = num;
				if(max < num) max = num;
				arr[j] = num;
			}
			
			int sum = 0;
			for (int j = 0; j < arr.length; j++) {
				if(arr[j] == min || arr[j] == max) continue;
				else sum += arr[j];
			}
			
			double average = (double)sum /8;
			bw.write("#"+String.valueOf(i)+" "+String.format("%.0f", average)+"\n");
		}
		
		bw.flush();
		bw.close();

	}

}
