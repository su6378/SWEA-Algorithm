import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(token.nextToken());
			int L = Integer.parseInt(token.nextToken());

			int[] score = new int[N];
			int[] calrories = new int[N];
			HashSet<Integer> set = new HashSet<Integer>();

			for (int i = 0; i < N; i++) {
				StringTokenizer token2 = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(token2.nextToken());
				calrories[i] = Integer.parseInt(token2.nextToken());
			}

			combination(0, L, 0, 0, score, calrories, set);
			
			List<Integer> list = new ArrayList<Integer>(set);
			
			Collections.sort(list,Collections.reverseOrder());
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(list.get(0))+"\n");
			
		}
		bw.flush();
		bw.close();
	}

	static void combination(int i, int calroie, int calroie_sum, int sum, int[] score, int[] calroies,
			HashSet<Integer> set) {
		if (calroie_sum > calroie) {
			return;
		}else set.add(sum);

		for (int j = i; j < calroies.length; j++) {
			combination(j + 1, calroie, calroie_sum + calroies[j], sum + score[j], score, calroies, set);
		}

	}
}
