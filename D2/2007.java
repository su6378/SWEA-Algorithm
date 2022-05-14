import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(token.nextToken());

		for (int i = 1; i <= T; i++) {
			String str = br.readLine().toString();
			for (int j = 1; j <= str.length(); j++) {
			 String a = str.substring(0,j);
			 String b = str.substring(j,j+j);
			 
			 if (a.equals(b)) {
				 bw.write("#"+String.valueOf(i)+" "+String.valueOf(a.length())+"\n");
				 break;
			 }
			}
			
		}

		bw.flush();
		bw.close();

	}
	
}
