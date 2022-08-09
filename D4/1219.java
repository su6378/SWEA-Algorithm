import java.io.*;
import java.util.*;



public class Solution {
	
	static List<Integer>[] navigation;
	static boolean[] visited;
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int T = 1; T <= 10; T++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int tNumber = Integer.parseInt(token.nextToken());
			int naviCount = Integer.parseInt(token.nextToken());
			
			navigation = new ArrayList[100];
			visited = new boolean[100];
			for (int i = 0; i < 100; i++) {
				navigation[i] = new ArrayList<Integer>(); 
			}
			
			token = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < naviCount; i++) {
				int start = Integer.parseInt(token.nextToken());
				int end = Integer.parseInt(token.nextToken());
				
				navigation[start].add(end);
			}
			
			result = 0;
			
			bfs(0, 99);
			
			
			bw.write("#"+String.valueOf(T)+" "+String.valueOf(result)+"\n");
		}
		

		bw.flush();
		bw.close();
	}
	
	static void bfs(int start, int end) {
		
		Queue<Integer> current = new LinkedList<Integer>();
		current.add(start);
		
		while(!current.isEmpty()) {
			int cSize = current.size();
			
			for (int i = 0; i < cSize; i++) {
				int parent = current.poll();
				for (Integer num : navigation[parent] ) {
					
					if (num == end) {
						result = 1;
						return;
					}else {
						if(!visited[num]) {
							visited[num] = true;
							current.add(num);
						}
					}
				}
			}
		}
	}
}
