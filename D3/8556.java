import java.io.*;
import java.util.*;

import org.omg.PortableInterceptor.INACTIVE;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
	
		for (int tc = 1; tc <= T; tc++) {
			
			String direction = br.readLine();
			StringBuilder sb = new StringBuilder();
			List<String> list = new ArrayList<String>();
			int idx = 0;
			for (int i = 0; i < direction.length(); i+=idx) {
				if (direction.charAt(i) == 'w') {
						list.add(0,direction.substring(i,i+4));
						idx = 4;
				}else if (direction.charAt(i) == 'n') {
					list.add(0,direction.substring(i,i+5));
					idx = 5;
				}
			}
			
			double a = 0;
			double dir = 0;
			for (int i = 0; i < list.size(); i++) {
				if (i == 0) {
					if (list.get(i).equals("west")) {
						dir = 90;
						a = dir;
					}
					else {
						dir = 0;
						a = dir;
					}
				}else {
					if (list.get(i).equals("west")) {
						dir = a + (90/Math.pow(2,i));
						a = dir;
					}else {
						dir = a - (90/Math.pow(2,i));
						a = dir;
					}
				}	
			}
			
			boolean isInt = true;
			if (dir != (int)dir) {
				isInt = false;
			}
			bw.write("#"+String.valueOf(tc)+" ");
			if (isInt) {
				bw.write(String.valueOf((int)dir)+"\n");
			}else {
				int count = 1;
				int num = 0;
				while (true) {
					count++;
					if (dir * count == (int) (dir * count)) {
						num = (int) (dir * count);
						break;
					}
				}
			 bw.write(String.valueOf(num)+"/"+String.valueOf(count)+"\n");
			}
			
			
			
			
		}
		bw.flush();
		bw.close();
	}
}




