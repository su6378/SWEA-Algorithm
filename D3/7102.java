import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int tc= 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(token.nextToken());
			int[] n_card = new int[N];
			
			for (int i = 0; i < N; i++) {
				n_card[i] = i+1;
			}
			
			int M = Integer.parseInt(token.nextToken());
			int[] m_card = new int[M];
			
			for (int i = 0; i < M; i++) {
				m_card[i] = i+1; 
			}
			
			
			Map<Integer, Integer> card_map = new HashMap<>();
			
			for (int i = 0; i < m_card.length; i++) {
				for (int j = 0; j < n_card.length; j++) {
					int sum = m_card[i] + n_card[j];
					
					if (card_map.containsKey(sum)) {
						card_map.put(sum, card_map.get(sum)+1);
					}else card_map.put(sum, 1);
				}
			}
			
			List<Integer> card_sort = new ArrayList<>(card_map.keySet());
			Collections.sort(card_sort, (value1, value2) -> (card_map.get(value2).compareTo(card_map.get(value1))));
			
			int max = card_map.get(card_sort.get(0));
			ArrayList<Integer> card_list = new ArrayList<>();
			
			for (Integer key : card_map.keySet()) {
	            Integer value = card_map.get(key);
	            
	            if (value == max) card_list.add(key);
	        }
			
			Collections.sort(card_list);
			bw.write("#"+String.valueOf(tc)+" ");
			
			for (int i = 0; i < card_list.size(); i++) {
				bw.write(String.valueOf(card_list.get(i)+" "));
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}

