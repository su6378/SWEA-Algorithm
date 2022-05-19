import java.io.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
		
			String[] current = br.readLine().split(":");
			String[] plan = br.readLine().split(":");
			
			int second = Integer.parseInt(plan[2]) - Integer.parseInt(current[2]);
			int minute = Integer.parseInt(plan[1]) - Integer.parseInt(current[1]);
			int hour = Integer.parseInt(plan[0]) - Integer.parseInt(current[0]);
			
			if (second < 0) {
				second += 60;
				minute -= 1;
			}
			
			if (minute < 0) {
				minute += 60;
				hour -= 1;
			}
			
			if (hour < 0) {
				hour += 24;
			}
			
			StringBuilder sb = new StringBuilder();
			if (hour / 10 == 0) sb.append("0"+String.valueOf(hour)+":");
			else sb.append(String.valueOf(hour)+":");
			if (minute / 10 == 0) sb.append("0"+String.valueOf(minute)+":");
			else sb.append(String.valueOf(minute)+":");
			if (second / 10 == 0) sb.append("0"+String.valueOf(second));
			else sb.append(String.valueOf(second));
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(sb.toString())+"\n");
			
		}
		bw.flush();
		bw.close();
	}
}








