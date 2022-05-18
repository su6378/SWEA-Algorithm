import java.io.*;
import java.util.StringTokenizer;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] building = new int[N];
			
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int i = 0; i < building.length; i++) {
				building[i] = Integer.parseInt(token.nextToken()); 
			}
			int rooms = 0;
			for (int i = 2; i < building.length-2; i++) {
				if (building[i] > 0) {
					if (building[i] > building[i-2] && building[i] > building[i-1] && building[i] > building[i+1] && building[i] > building[i+2]) {
						int high = Math.max(building[i-2],Math.max(building[i-1],Math.max(building[i+1],building[i+2])));
						rooms += building[i] - high; 
					}
				}else continue;
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(rooms)+"\n");
		}
		bw.flush();
		bw.close();
	}
} 

