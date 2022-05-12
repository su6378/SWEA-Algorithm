package Main;

import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(token.nextToken());
			arr[i] = num;
		}

		Arrays.sort(arr);

		System.out.println(arr[N / 2]);

	}
}

//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));