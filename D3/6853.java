import java.io.*;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(token.nextToken());
			int y1 = Integer.parseInt(token.nextToken());
			int x2 = Integer.parseInt(token.nextToken());
			int y2 = Integer.parseInt(token.nextToken());
			
			int N  = Integer.parseInt(br.readLine());
			
			int inside = 0;
			int onside = 0;
			int outside = 0;
			
			
			for (int i = 0; i < N; i++) {
				StringTokenizer token2 = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(token2.nextToken());
				int y = Integer.parseInt(token2.nextToken());
				
				if(x < x1 || x > x2 || y < y1 || y > y2) outside++;
				else if(x == x1 || x == x2) {
					if(y >= y1 && y <= y2 ) onside++;
				}else if(y == y1 || y == y2){
					if(x >= x1 && x <= x2 ) onside++;
				}
				else if(x > x1 && x < x2 && y > y1 && y < y2) inside++;
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(inside)+" "+String.valueOf(onside)+" "+String.valueOf(outside)+"\n");

		}
		bw.flush();
		bw.close();
	}
}

