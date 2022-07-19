import java.io.*;
import java.util.*;
import java.util.function.LongToDoubleFunction;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int test_case = Integer.parseInt(br.readLine());
			int[] aliquots = new int[test_case];
			StringTokenizer token = new StringTokenizer(br.readLine());
			int max = 0;
			int min = Integer.MAX_VALUE;
			
			for (int i = 0; i < aliquots.length; i++) {
				int aliquot = Integer.parseInt(token.nextToken());
				aliquots[i] = aliquot;
				if (max < aliquot ) max = aliquot;
				
				if(min > aliquot) min = aliquot;
			}
			
			long password = max * min;
			
			bw.write("#"+String.valueOf(tc)+" "+password+"\n");
			
		
			
		}

		bw.flush();
		bw.close();

	}

}
