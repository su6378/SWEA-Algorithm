import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int K = Integer.parseInt(token.nextToken());
			
			String[] result_arr = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
			Double[] report = new Double[N];
			Double[] rank = new Double[N];
			
			for (int j = 0; j < report.length; j++) {
				StringTokenizer token2 = new StringTokenizer(br.readLine());
				int mid_score = Integer.parseInt(token2.nextToken());
				int final_score = Integer.parseInt(token2.nextToken());
				int assignment_score = Integer.parseInt(token2.nextToken());
				
				double score = ((double)mid_score*0.35) +((double)final_score*0.45) + ((double)assignment_score * 0.2);
				
				report[j] = score;
				rank[j] = score; 
			}
			
			Arrays.sort(rank,Collections.reverseOrder());
	
			double result = report[K-1];
			
			int index = 0;
			
			for (int j = 0; j < rank.length; j++) {
				if (result == rank[j]) {
					index = j;
				}
			}
			
			index = index / (N/10);
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(result_arr[index])+"\n");
			
			
					
			
		}
		
		bw.flush();
		bw.close();

	}

}
