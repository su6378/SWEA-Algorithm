import java.io.*;

class Solution {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < str.length(); i++) {
				sb.append(str.charAt(i));
			}
			
			String reverse = sb.reverse().toString();
			boolean match = true;
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) != reverse.charAt(i) && reverse.charAt(i) != '?' && str.charAt(i) != '?') {
						match = false;
						break;
				}
			}
			bw.write("#"+String.valueOf(tc)+" ");
			if(match) bw.write("Exist\n");
			else bw.write("Not exist\n");
		}
		bw.flush();
		bw.close();
	}
}
