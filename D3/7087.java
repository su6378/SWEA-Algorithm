import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		char[] alphabet = new char[26];
		int idx = 0;
		for (char i = 'A'; i <='Z'; i++) {
			alphabet[idx] =  i; 
			idx++;
		}
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int target = 0;
			int count = 0;
		
			HashSet<Character> set = new HashSet<Character>(); 
	
			for (int i = 0; i < N; i++) {
				String word = br.readLine();
				set.add(word.charAt(0));
			}
			
			List<Character> title = new ArrayList<Character>(set);
			
			Collections.sort(title);
			
			for (int i = 0; i < title.size(); i++) {
				if (title.get(i) == alphabet[i]) {
					count++;
				}else break;
			}
			
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(count)+"\n");
		}
		bw.flush();
		bw.close();
	}
}




