import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		char[] zero_point = {'C','E','F','G','H','I','J','K','L','M','N','S','T','U','V','W','X','Y','Z'};
		char[] one_point = {'A','D','O','P','Q','R'};
		
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		
		for (int i = 0; i < zero_point.length; i++) {
			map.put(zero_point[i],0);
		}
		
		for (int i = 0; i < one_point.length; i++) {
			map.put(one_point[i],1);
		}
		map.put('B',2);
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			char[] word = token.nextToken().toCharArray();
			char[] word2 = token.nextToken().toCharArray();
			boolean isSame = true;
			
			if(word.length != word2.length) isSame = false;
			else {
				for (int i = 0; i < word.length; i++) {
					if(map.get(word[i]) != map.get(word2[i])) {
						isSame = false;
						break;
					}
				}
			}
		
			bw.write("#"+String.valueOf(tc)+" ");
			if(isSame) bw.write("SAME\n");
			else bw.write("DIFF\n");
		}
		bw.flush();
		bw.close();
	}
}

