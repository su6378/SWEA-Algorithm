import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc= 1; tc <= T; tc++) {
			String str = br.readLine();
			int lastIndex = Character.getNumericValue(str.charAt(str.length()-1));
			String distinct = "";
			
			if (lastIndex % 2 == 0) distinct = "Even";
			else distinct = "Odd";
			
			bw.write("#"+String.valueOf(tc)+" "+distinct+"\n");
			
		}
		bw.flush();
		bw.close();
	}
}


