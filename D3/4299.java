import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(token.nextToken());
			int H = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());
			int minutes = 0;
			
			if (D < 11) {
				minutes = -1;
			}else if(D == 11 && H < 11) {
				minutes = -1;
			}else if (D == 11 && H == 11 && M < 11) {
				minutes = -1;
			}else {
				if (M - 11 < 0) {
					M = 60 - Math.abs(M - 11);
					if (H - 1 < 0) {
						H = 23;
					} else H--;
				}else M -= 11;
				
				if (H - 11 < 0) {
					H = 24 - Math.abs(H - 11);
					D--;
				}else H -= 11;
				
				D -= 11;
				minutes += D * 24 * 60;
				minutes += H * 60;
				minutes += M;
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(minutes)+"\n");
			

		}
		bw.flush();
		bw.close();
	}
	
	static void combination(int i, int sum, int size, int[] card, HashSet<Integer> set) {
		if (size == 3) {
			set.add(sum);
			return;
		}
		
		for (int j = i; j < card.length; j++) {
			combination(j+1,sum + card[j],size+1,card,set);
		}
	}
}

