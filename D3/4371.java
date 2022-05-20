import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] good_day = new int[N];
			List<Integer> boat = new ArrayList<Integer>();
			
			for (int i = 0; i < N; i++) {
				good_day[i] = Integer.parseInt(br.readLine());
			}
			int count = 0;
			bw.write("#"+String.valueOf(tc)+" ");
			if (N == 2) {
				bw.write("2\n");
			}else {
				for (int i = 1; i < good_day.length; i++) {
					if (boat.isEmpty()) {
						boat.add(good_day[i] - 1);
					}else {
						boolean isSame = true;
						int rule = good_day[i] - 1;
						for (int j = 0; j < boat.size(); j++) {
							if(rule % boat.get(j) == 0) {
								isSame = false;
								break;
							}
						}
						if(isSame) boat.add(rule);
					}
				}
				bw.write(String.valueOf(boat.size())+"\n");
			}
			
			
			
			
			
			
		}
		bw.flush();
		bw.close();
	}
}
