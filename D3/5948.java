import java.io.*;
import java.util.*;
import java.util.function.IntPredicate;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer token = new StringTokenizer(br.readLine());
			int[] card = new int[7];
			
			HashSet<Integer> set = new HashSet<Integer>();
			
			for (int i = 0; i < card.length; i++) {
				card[i] = Integer.parseInt(token.nextToken()); 
			}
			
			combination(0,0,0,card,set);
			
			List<Integer> list = new ArrayList<Integer>(set);
			Collections.sort(list,Collections.reverseOrder());
			bw.write(String.valueOf(list)+"\n");
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(list.get(4))+"\n");

		}
		bw.flush();
		bw.close();
	}
	
	static void combination(int i, int sum, int size, int[] card, HashSet<Integer> set) {
		if (size == 3) {
			set.add(sum);
			return;
		}
		
		for (int j = i; j < card.length; j++) {
			combination(j+1,sum + card[j],size+1,card,set);
		}
	}
}

