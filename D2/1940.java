package Main;

import java.io.*;
import java.util.*;



class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int distance = 0;
			int speed = 0;
			int N = Integer.parseInt(br.readLine());
			for (int j = 0; j < N; j++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(token.nextToken());
				switch (command) {
				case 0:
					break;
				case 1:
					speed += Integer.parseInt(token.nextToken());
					break;
				case 2:
					speed -= Integer.parseInt(token.nextToken());
					break;
				}
				if(speed <0) speed = 0;
				distance += speed;
			}
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(distance)+"\n");
		}

		bw.flush();
		bw.close();
	}
}
