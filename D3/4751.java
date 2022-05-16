import java.io.*;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int i = 1; i <= T; i++) {
			String str = br.readLine();
			StringBuilder sb = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			StringBuilder sb3 = new StringBuilder();
			StringBuilder sb4 = new StringBuilder();
			StringBuilder sb5 = new StringBuilder();
			
			if (str.length() == 1) {
				sb.append("..#..");
				sb2.append(".#.#.");
				sb3.append("#."+str+".#");
				sb4.append(".#.#.");
				sb5.append("..#..");
			}else {
				for (int j = 0; j < str.length(); j++) {
					if (j==0) {
						sb.append("..#..");
						sb2.append(".#.#.");
						sb3.append("#."+str.charAt(j)+".#");
						sb4.append(".#.#.");
						sb5.append("..#..");
					}else {
						sb.append(".#..");
						sb2.append("#.#.");
						sb3.append("."+str.charAt(j)+".#");
						sb4.append("#.#.");
						sb5.append(".#..");
					}
				}
			}
			
			bw.write(sb.toString()+"\n");
			bw.write(sb2.toString()+"\n");
			bw.write(sb3.toString()+"\n");
			bw.write(sb4.toString()+"\n");
			bw.write(sb5.toString()+"\n");
		}
		bw.flush();
		bw.close();
	}
}

