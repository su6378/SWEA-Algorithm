import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		int[] month_cal = {4,0,1,4,6,2,4,0,3,5,1,3};
		
		for (int tc= 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int month = Integer.parseInt(token.nextToken());
			int day = Integer.parseInt(token.nextToken());
			
			int today = month_cal[month-1];
			int day2 = day - 1;
			
			int result = (day2 + today) % 7;
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(result)+"\n");
		}
		bw.flush();
		bw.close();
	}
}


