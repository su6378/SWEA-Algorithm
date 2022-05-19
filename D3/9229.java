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
			int M = Integer.parseInt(token.nextToken());
			int[] snacks = new int[N];
			StringTokenizer token2 = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < snacks.length; i++) {
				snacks[i] = Integer.parseInt(token2.nextToken()); 
			}
			
			HashSet<Integer> set = new HashSet<Integer>();
			
			combination(0,0,snacks,0,M,set);
			
			List<Integer> list = new ArrayList<Integer>(set);
			Collections.sort(list,Collections.reverseOrder());
			
			bw.write("#"+String.valueOf(tc)+" ");
			if (list.isEmpty()) {
				bw.write("-1\n");
			}else {
				bw.write(String.valueOf(list.get(0))+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
	
	static void combination(int i, int size,int[] snacks,int sum,int max,HashSet<Integer> set) {
		if (size == 2) {
			if (sum <= max) {
				set.add(sum);
			}
			return;
		}
		
		for (int j = i; j < snacks.length; j++) {
			combination(j+1,size+1,snacks,sum + snacks[j],max,set);
		}
	}
}


