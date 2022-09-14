import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			String case_num = token.nextToken();
			int N = Integer.parseInt(token.nextToken());
			int[] word = new int[N];
			String[] number = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
			HashMap<String,Integer> map = new HashMap<String,Integer>();
			
			for (int i = 0; i < number.length; i++) {
				map.put(number[i],i);
			}
			
			StringTokenizer token2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				word[i] = map.get(token2.nextToken()); 
			}
			
			Arrays.sort(word);
			bw.write("#"+String.valueOf(tc)+"\n");
			
			while(true) {
				for (int i = 0; i < word.length; i++) {
					for(String key : map.keySet()) {
						
						if (map.get(key) == word[i]) {
							bw.write(String.valueOf(key)+" ");	
						}
					}
					
				}
				break;
			}
			
			bw.write("\n");
			
		}
		bw.flush();
		bw.close();
	}
} 