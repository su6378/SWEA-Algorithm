import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			bw.write("#"+String.valueOf(i)+" ");
			
			for (int j = 1; j <= N; j++) {
				bw.write(String.valueOf("1")+"/"+String.valueOf(N)+" ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}
