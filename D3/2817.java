import java.io.*;
import java.util.StringTokenizer;

class Solution {
	public static boolean[] check;
	public static int count;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int K = Integer.parseInt(token.nextToken());

			check = new boolean[N];
			count = 0;

			int[] numbers = new int[N];
			StringTokenizer token2 = new StringTokenizer(br.readLine());

			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = Integer.parseInt(token2.nextToken());
			}
			
			combination(0,K,numbers,0);
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(count)+"\n");

		}
		bw.flush();
		bw.close();
	}

	static void combination(int sum, int K, int[] numbers,int previous) {
		if (sum == K) {
			sum = 0;
			count++;
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (!check[i] && i >= previous) {
				check[i] = true;
				combination(sum + numbers[i], K, numbers,i);
				check[i] = false;
			}
			
		}
	}
}
