import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String[] str = br.readLine().split(" ");
			int tLength = Integer.parseInt(str[1]);
			int[] numArr = new int[tLength];

			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int i = 0; i < tLength; i++) { // 문자열을 숫자로 변환 후 배열에 넣기
				String num = token.nextToken();
				switch (num) {
				case "ZRO":
					numArr[i] = 0;
					break;
				case "ONE":
					numArr[i] = 1;
					break;
				case "TWO":
					numArr[i] = 2;
					break;
				case "THR":
					numArr[i] = 3;
					break;
				case "FOR":
					numArr[i] = 4;
					break;
				case "FIV":
					numArr[i] = 5;
					break;
				case "SIX":
					numArr[i] = 6;
					break;
				case "SVN":
					numArr[i] = 7;
					break;
				case "EGT":
					numArr[i] = 8;
					break;
				case "NIN":
					numArr[i] = 9;
					break;
				}

			}

			Arrays.sort(numArr); // 정렬

			String[] sortArr = new String[tLength];

			for (int i = 0; i < tLength; i++) { //정렬한 값을 문자열로 변환해서 배열로 넣기
				switch (numArr[i]) {
				case 0:
					sortArr[i] = "ZRO";
					break;
				case 1:
					sortArr[i] = "ONE";
					break;
				case 2:
					sortArr[i] = "TWO";
					break;
				case 3:
					sortArr[i] = "THR";
					break;
				case 4:
					sortArr[i] = "FOR";
					break;
				case 5:
					sortArr[i] = "FIV";
					break;
				case 6:
					sortArr[i] = "SIX";
					break;
				case 7:
					sortArr[i] = "SVN";
					break;
				case 8:
					sortArr[i] = "EGT";
					break;
				case 9:
					sortArr[i] = "NIN";
					break;
				}
			}
			
			
			
			bw.write("#"+String.valueOf(tc)+"\n");
			
			for (int i = 0; i < sortArr.length; i++) {
				bw.write(sortArr[i]+" ");
			}
			
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
