package Main;

import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int P = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		int count = 1;
		
		while (true) {
			if (K == P) {
				break;
			}
			K++;
			count++;
		}
		
		System.out.println(count);
		

	}
}

