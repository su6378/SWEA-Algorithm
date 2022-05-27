import java.io.*;
import java.util.*;

class Solution {

	public static boolean[] check;
	public static HashSet<Character> set;
	public static int count;

	public static void main(String args[]) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] word = new String[N];

			for (int i = 0; i < word.length; i++) {
				word[i] = br.readLine();
			}

			check = new boolean[N];
			String str ="";
			count = 0;

			check(0,str, word,0);
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(count)+"\n");
		}
		bw.flush();
		bw.close();
	}

	static void check(int size,String str, String[] word,int previous) {
		if (str.length() >= 26) {
			set = new HashSet<Character>();
			for (int i = 0; i < str.length(); i++) {
				set.add(str.charAt(i));
			}
			
			if(set.size() == 26) {
				count++;
			}
			
			if(previous == word.length-1) {
				str="";
				return;
			}
			
		}
		for (int i = 0; i < word.length; i++) {
			if (!check[i] && i >= previous) {
				check[i] = true;
				check(size + 1,str.concat(word[i]), word,i);
				check[i] = false;
			}

		}

	}
}
