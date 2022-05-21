import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			HashSet<Integer> set = new HashSet<Integer>();
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				set.add(Integer.parseInt(token.nextToken()));
			}
			
			boolean permutation = true;
			if(set.size() != N) {
				permutation = false;
			}else {
				ArrayList<Integer> list = new ArrayList<Integer>(set);
				Collections.sort(list);
				
				for (int i = 0; i < list.size(); i++) {
					if(list.get(i) != (i + 1)) {
						permutation = false;
						break;
					}
				}
			}
		
			bw.write("#"+String.valueOf(tc)+" ");
			if(permutation) bw.write("Yes\n");
			else bw.write("No\n");
		}
		bw.flush();
		bw.close();
	}
}
