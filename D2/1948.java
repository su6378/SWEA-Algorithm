package Main;

import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(token.nextToken());

		for (int i = 1; i <= T; i++) {
			StringTokenizer date_token = new StringTokenizer(br.readLine());
			int month1 = Integer.parseInt(date_token.nextToken());
			int day1 = Integer.parseInt(date_token.nextToken());
			int month2 = Integer.parseInt(date_token.nextToken());
			int day2 = Integer.parseInt(date_token.nextToken());
			
			int days = 1;
			while (true) {
				if (month1 == month2 && day1 == day2) break;
				
				day1++;
				days++;
				
				if (month1 == 2) {
					if (day1 > 28) {
						month1++;
						day1 = 1;
					}
				}else if(month1 == 4 || month1 == 6 || month1 == 9 || month1 == 11) {
					if (day1 > 30) {
						month1++;
						day1 = 1;
					}
				}else {
					if(day1 > 31) {
						month1++;
						day1 = 1;
					}
				}
			}
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(days)+"\n");
		}

		bw.flush();
		bw.close();
	}
}
