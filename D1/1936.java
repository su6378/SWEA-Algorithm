package Main;

import java.io.*;
import java.util.StringTokenizer;


class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(token.nextToken());
		int B = Integer.parseInt(token.nextToken());
		
		if (A > B) System.out.println("A");
		else System.out.println("B");
		
	}
}

