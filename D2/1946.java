import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			int width = 0;
			
			for(int j = 1 ; j <= N; j++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				String chr = token.nextToken();
				int repeat = Integer.parseInt(token.nextToken());
			
				for (int k = 0; k < repeat; k++) {
					sb.append(chr);
					width++;
					if (width % 10 == 0) {
						sb.append("\n");
						width = 0;
					}
				}
			}
			
			bw.write("#"+String.valueOf(i)+"\n"+sb.toString()+"\n");
			
		}
		
		bw.flush();
		bw.close();

	}

}
