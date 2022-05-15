import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String str2 = br.readLine();
			
			int count = 0;
			
			for (int j = 0; j < N; j++) {
				if(str.charAt(j) == str2.charAt(j)) count++;
			}
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(count)+"\n");
			
		}

		bw.flush();
		bw.close();
	}
}

