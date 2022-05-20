import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());

			double D = Double.parseDouble(token.nextToken());
			double A = Double.parseDouble(token.nextToken());
			double B = Double.parseDouble(token.nextToken());
			double F = Double.parseDouble(token.nextToken());
			double distance = 0;
			
			double time = D / (B+F);
			
			
			distance += F * time;
			
			
			D -= (A * time) + (B * time);
			
			
			time = D / (A+B);
			
			distance += F * time;
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(distance)+"\n");
			//String.format("%9f",distance)
		}
		bw.flush();
		bw.close();
	}
}



