import java.io.*;
import java.util.*;

public class Solution {
	
	static boolean visited[];
	static int[][] work;
	static StringBuilder sb;
	static Stack<Integer> stack = new Stack<Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int T = 1; T <= 10; T++) {
			
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			int points = Integer.parseInt(token.nextToken());
			int lines = Integer.parseInt(token.nextToken());
			int check[] = new int[points+1];
			check[0] = 1;
			
			visited = new boolean[points+1];
			work = new int[points+1][points+1];
			
			token = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < lines; i++) {
				int start = Integer.parseInt(token.nextToken());
				int end = Integer.parseInt(token.nextToken());
				
				work[start][end]= 1;
				check[end] = 1;
			}
			
			sb = new StringBuilder();
			
			
			for (int i = 0; i < check.length ; i++) {
				if (check[i] == 0) {
					stack.push(i);
					visited[i] = true; 
				}
			}
			
			dfs();
			
			bw.write("#"+String.valueOf(T)+" "+sb+"\n");
			
		}

		bw.flush();
		bw.close();
	}
	
	static void dfs() {
		while (!stack.isEmpty()) {
			int parent = stack.pop();
			sb.append(parent+" ");
			
			for (int i = 1; i < work.length; i++) {
				if (work[parent][i] == 1) {
					work[parent][i] = 0;
					
					boolean isWork = true;
					for (int j = 1; j < work.length; j++) {
						if (work[j][i] == 1) {
							isWork = false;
							break;
						}
					}
					
					if (isWork) {
						stack.add(i);
					}
				}
			}
		}
	}
}
