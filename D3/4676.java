import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String word = br.readLine();
			List<Character> list = new LinkedList<>();
			
			for (int i = 0; i < word.length(); i++) {
				list.add(word.charAt(i));
			}
			
			int N = Integer.parseInt(br.readLine());
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
			for (int i = 0; i < N; i++) {
				int key = Integer.parseInt(token.nextToken())-1;
				if (map.containsKey(key)) map.put(key,map.get(key)+1);
				else map.put(key,1);
			}
			
			bw.write("#"+String.valueOf(tc)+" ");
			
			if (map.containsKey(-1)) {
				int repeat = map.get(-1);
				for (int i = 0; i < repeat; i++) {
					bw.write("-");
				}
			}
			
			for (int i = 0; i < list.size(); i++) {
				if (map.containsKey(i)) {
					int repeat = map.get(i);
					bw.write(String.valueOf(list.get(i)));
					for (int j = 0; j < repeat; j++) {
						bw.write("-");
					}
				}else bw.write(String.valueOf(list.get(i)));
			}
			
			bw.write("\n");
			
		}
		bw.flush();
		bw.close();
	}
}

