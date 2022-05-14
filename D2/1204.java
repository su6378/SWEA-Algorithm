import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer token = new StringTokenizer(br.readLine());
			HashMap<Integer, Integer> map = new HashMap<>();

			for (int j = 0; j < 1000; j++) {
				int num = Integer.parseInt(token.nextToken());
				if (map.containsKey(num)) {
					map.put(num, map.get(num) + 1);
				} else
					map.put(num, 1);
			}

			int[] value = new int[map.size()];
			int max = 0;
			for (int j = 0; j < map.size(); j++) {
				value[j] = map.get(j);
				if (max < map.get(j))
					max = map.get(j);
			}
			
			int result = 0;
			Set<Entry<Integer, Integer>> entrySet = map.entrySet();
			for (Entry<Integer, Integer> entry : entrySet) {
				if (entry.getValue() == max) {
					if(result < entry.getKey()) result = entry.getKey();
				}
			}
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(result)+"\n");
		}

		bw.flush();
		bw.close();

	}

}
