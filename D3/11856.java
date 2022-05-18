import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();

			HashMap<Character, Integer> map = new HashMap<Character, Integer>();

			for (int i = 0; i < str.length(); i++) {
				char key = str.charAt(i);
				if (map.containsKey(key))
					map.put(key, map.get(key) + 1);
				else
					map.put(key, 1);
			}
			boolean check = false;

			for (Character key : map.keySet()) {
				if (map.get(key) == 2) check = true;
				else {
					check = false;
					break;
				}
			}

			bw.write("#" + String.valueOf(tc) + " ");
			if (check)
				bw.write("Yes\n");
			else
				bw.write("No\n");
		}
		bw.flush();
		bw.close();
	}
}