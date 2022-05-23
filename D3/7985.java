import java.io.*;
import java.util.*;

class Solution {
	public static int N;
	public static int[] answer;
	public static int[] tree;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt((br.readLine()));
			
			N =(int) Math.pow(2,K) - 1;
			tree = new int[N];
			answer = new int[N];
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(token.nextToken()); 
			}
			
			search(0,N-1,1);
			
			bw.write("#"+String.valueOf(tc)+" ");
			int cnt = 0;
			for (int i = 0; i < K; i++) {
				for (int j = 0; j < Math.pow(2,i); j++) {
					bw.write(String.valueOf(answer[cnt++])+" ");
				}
				bw.write("\n");
			}

		}
		bw.flush();
		bw.close();
		
	}
	static void search(int start, int end, int idx) {
		if(start < 0 || start > N || end < 0 || end > N || idx > N) return;
		
		int mid = (start + end) / 2;
		answer[idx - 1] = tree[mid];
		if(start == end) return;
		search(start,mid - 1,2 * idx);
		search(mid+1,end,2*idx+1);
		
	}
}
