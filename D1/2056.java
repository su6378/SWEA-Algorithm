import java.util.*;

import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			String date = br.readLine().toString();
			String year = date.substring(0,4);
			String month_str = date.substring(4,6);
			int month = Integer.parseInt(date.substring(4, 6));

			if (month > 0 && month < 13) {
				int day = Integer.parseInt(date.substring(6));
				String day_str = date.substring(6);
				
				if (day > 0 && day <32) {
					if (month == 2) {
						if (day > 28) bw.write("#" + String.valueOf(i) + " " + "-1\n");
						else bw.write("#" + String.valueOf(i) + " " +year+"/"+month_str+"/"+day_str+ "\n");
					}else if(month == 4 || month == 6 || month == 9 || month == 11) {
						if(day > 30) bw.write("#" + String.valueOf(i) + " " + "-1\n");
						else bw.write("#" + String.valueOf(i) + " " +year+"/"+month_str+"/"+day_str+ "\n");
					}else bw.write("#" + String.valueOf(i) + " " +year+"/"+month_str+"/"+day_str+ "\n");
				}
			}else bw.write("#" + String.valueOf(i) + " " + "-1\n");

		}

		bw.flush();
		bw.close();

	}

}
