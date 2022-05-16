import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken()); 
			int M = Integer.parseInt(token.nextToken());
			
			int[][] arr = new int[N][M];
			int col = 0;
			int row = 0;
			boolean isExist = false;
			
			for (int j = 0; j < N; j++) {
				String str = br.readLine();
				for (int k = 0; k < M; k++) {
					arr[j][k] = Character.getNumericValue(str.charAt(k)); 
					if (Character.getNumericValue(str.charAt(k)) == 1) {
						col = k;
						isExist = true;
					}
				}
				if (isExist) row = j;
				isExist = false;
			}
			
			LinkedList<Integer> code_list = new LinkedList<Integer>();
			
			for (int j = col-55; j <= col; j+=7) {
				StringBuilder sb = new StringBuilder();
				for (int k = j; k < j+7; k++) {
					sb.append(arr[row][k]);
				}
				String code = sb.toString();
			
				switch (code) {
				case "0001101":
					code_list.add(0);
					break;
				case "0011001":
					code_list.add(1);
					break;
				case "0010011":
					code_list.add(2);
					break;
				case "0111101":
					code_list.add(3);
					break;
				case "0100011":
					code_list.add(4);
					break;
				case "0110001":
					code_list.add(5);
					break;
				case "0101111":
					code_list.add(6);
					break;
				case "0111011":
					code_list.add(7);
					break;
				case "0110111":
					code_list.add(8);
					break;
				case "0001011":
					code_list.add(9);
					break;
				}
			}
			
			int odd = 0;
			int even = 0;
			int sum = 0;
			for (int j = 0; j < code_list.size(); j++) {
				if (j % 2 == 0) odd += code_list.get(j);
				else even += code_list.get(j);
				sum += code_list.get(j);
			}
			int vertification = (odd * 3) + even;
			
			if (vertification % 10 == 0) {
				bw.write("#"+String.valueOf(i)+" "+String.valueOf(sum)+"\n");
			}else bw.write("#"+String.valueOf(i)+" 0\n");
			
		}
		bw.flush();
		bw.close();
	}
}