import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			StringBuilder progression = new StringBuilder();

			for (int i = 0; i < N; i++) {
				progression.append(sc.nextInt());

			}
			
			int min = 0;
			
			for (int i = 0; i <= 1000; i++) {
				if(!progression.toString().contains(String.valueOf(i))) {
					min = i;
					break;
				}
			}

			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(min) + "\n");

		}
		bw.flush();
		bw.close();
	}

}
