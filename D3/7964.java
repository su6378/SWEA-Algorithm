import java.io.*;
import java.util.StringTokenizer;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int D = Integer.parseInt(token.nextToken());

			int[] kingdom = new int[N];
			StringTokenizer token2 = new StringTokenizer(br.readLine());

			for (int i = 0; i < kingdom.length; i++) {
				kingdom[i] = Integer.parseInt(token2.nextToken());
			}

			int gate = 0;

			if (kingdom[0] == 0) {
				kingdom[0] = 1;
				gate++;
			}

			if (kingdom[N - 1] == 0) {
				kingdom[N - 1] = 1;
				gate++;
			}
			
			for (int i = 0; i < kingdom.length-D; i++) {
				if (kingdom[i] == 1 && i + D <= kingdom.length - 1) {
					boolean isGate = false;
					for (int j = 1; j <= D; j++) {
						if(kingdom[i+j] == 1) {
							isGate = true;
							break;
						}
					}
					
					if(!isGate) {
						kingdom[i + D] = 1;
						gate++;
					}
				}
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(gate)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
