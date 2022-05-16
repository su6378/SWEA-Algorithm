import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int tc= 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			List<Integer> students = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				students.add(i+1);
			}
			
			int K = Integer.parseInt(token.nextToken());
			StringTokenizer token2 = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < K; i++) {
				int report = Integer.parseInt(token2.nextToken());
				students.remove(Integer.valueOf(report));
			}
			bw.write("#"+String.valueOf(tc)+" ");
			
			for (int i = 0; i < students.size(); i++) {
				bw.write(String.valueOf(students.get(i))+" ");
			}
			
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}


