import java.io.*;
import java.util.*;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		ArrayList<Character> big = new ArrayList<Character>();
		for (char i = 'A'; i <= 'Z'; i++) {
			big.add(i);
		}

		ArrayList<Character> small = new ArrayList<Character>();
		for (char i = 'a'; i <= 'z'; i++) {
			small.add(i);
		}

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			String[] setences = br.readLine().split("\\.|\\?|\\!");
			bw.write("#"+String.valueOf(tc)+" ");
			
			for (int i = 0; i < setences.length; i++) {
				String[] word = setences[i].split(" ");
				int count = 0;
				
				for (int j = 0; j < word.length; j++) {
					if (word[j].equals(""))
						continue;
					boolean isName = true;

					char first = word[j].charAt(0);
					if (big.contains(first)) {
						for (int k = 1; k < word[j].length(); k++) {
							char rest = word[j].charAt(k);
							if (!small.contains(rest)) {
								isName = false;
								break;
							}
						}
						if(isName) count++;
					}
				}
				bw.write(String.valueOf(count)+" ");
			}
			bw.write("\n");
			

		}

		bw.flush();
		bw.close();
	}
}
