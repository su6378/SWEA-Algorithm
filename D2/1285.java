import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			int min_distance = Integer.MAX_VALUE;
			int count = 1;
			for (int j = 0; j < N; j++) {
				int stone_idx = Math.abs(Integer.parseInt(token.nextToken()));
				if (min_distance > stone_idx) min_distance = stone_idx;
				else if (min_distance == stone_idx) count++;
			}
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(min_distance)+" "+count+"\n");
			

		}

		bw.flush();
		bw.close();

	}
}
