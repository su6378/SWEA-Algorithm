import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int i = 1; i <= T; i++) {
			int angle = Integer.parseInt((br.readLine().trim()));
			
			int total_time = angle * 2;
			int hour = 0;
			int minutes = 0;
			
			if (total_time >= 60) {
				hour += total_time / 60;
				minutes += total_time % 60;
			}else minutes += total_time;
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(hour)+" "+String.valueOf(minutes)+"\n");
		}
		
		bw.flush();
		bw.close();
	}

}
