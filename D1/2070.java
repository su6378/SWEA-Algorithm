package Main;

import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(token.nextToken());
			int num2 = Integer.parseInt(token.nextToken());
			
			if(num1 < num2) bw.write("#"+String.valueOf(i)+" "+"<\n");
			else if(num1 == num2) bw.write("#"+String.valueOf(i)+" "+"=\n");
			else bw.write("#"+String.valueOf(i)+" "+">\n");
		}

		bw.flush();
		bw.close();
	}
}