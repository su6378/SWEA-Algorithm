package Main;

import java.io.*;
import java.util.StringTokenizer;


class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(token.nextToken());
		
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			int e = 0;
			
			while(true) {
				if(N % 2 != 0) break;
				N /= 2;
				a++;
			}
			
			while(true) {
				if(N % 3 != 0) break;
				N /= 3;
				b++;
			}
			
			while(true) {
				if(N % 5 != 0) break;
				N /= 5;
				c++;
			}
			
			while(true) {
				if(N % 7 != 0) break;
				N /= 7;
				d++;
			}
			
			while(true) {
				if(N % 11 != 0) break;
				N /= 11;
				e++;
			}
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(a)+" "+String.valueOf(b)+" "+String.valueOf(c)+" "+String.valueOf(d)+" "+String.valueOf(e)+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}

