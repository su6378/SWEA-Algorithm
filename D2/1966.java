import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer token = new StringTokenizer(br.readLine());

			int[] arr = new int[N];
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(token.nextToken());
				arr[j] = num;
			}
			
			Arrays.sort(arr);
			
			bw.write("#"+String.valueOf(i)+" ");
			for (int j = 0; j < arr.length; j++) {
				bw.write(String.valueOf(arr[j])+" ");
			}
			bw.write("\n");

		}

		bw.flush();
		bw.close();

	}
}
