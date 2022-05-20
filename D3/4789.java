import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			String person = br.readLine();

			int[] clap = new int[person.length()];

			for (int i = 0; i < person.length(); i++) {
				clap[i] = Character.getNumericValue(person.charAt(i));
			}
			
			int clap_person = 0;
			int hire = 0;
			for (int i = 0; i < clap.length; i++) {
				if (i == 0) clap_person = clap[i];
				else {
					if(clap[i] != 0) {
						if(clap_person >= (i+1) - 1) clap_person += clap[i];
						else {
							hire += i - clap_person;
							clap_person = i+clap[i];
						}
					}
				}
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(hire)+"\n");

		}
		bw.flush();
		bw.close();
	}
}

