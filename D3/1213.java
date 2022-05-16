import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		for (int i = 1; i <= 10; i++) {
			int N = Integer.parseInt(br.readLine());
			String target = br.readLine();
			String str = br.readLine();
			int count = 0;
			
			for (int j = 0; j <= str.length()-target.length(); j++) {
				StringBuilder sb = new StringBuilder();
				for (int k = j; k < j + target.length() ; k++) {
					sb.append(str.charAt(k));
				}
				String match = sb.toString();
				if (match.equals(target)) count++;
			}
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(count)+"\n");
			
			
			
		}
		bw.flush();
		bw.close();
	}
}







