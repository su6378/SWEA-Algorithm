import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		int[] gugudan = new int[81];
		int dan = 0;
		for (int j = 1; j <= 9; j++) {
			for (int k = 1; k <= 9; k++) {
				gugudan[dan] = k * j;
				dan++;
			}
		}

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			bw.write("#" + String.valueOf(tc) + " ");

			List<Integer> list = Arrays.stream(gugudan).boxed().collect(Collectors.toList());

			if(list.contains(Integer.valueOf(N))) bw.write("Yes\n");
			else bw.write("No\n");

		}
		bw.flush();
		bw.close();
	}
}
