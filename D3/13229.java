import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		String[] day_arr = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
		
		for (int tc= 1; tc <= T; tc++) {
			String day = br.readLine();
			int today =  Arrays.asList(day_arr).indexOf(day);
			int left_day = 6 - today;
			
			if (left_day == 0) left_day = 7;
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(left_day)+"\n");
			
			
		}
		bw.flush();
		bw.close();
	}
}
