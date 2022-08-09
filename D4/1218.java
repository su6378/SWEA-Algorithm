import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int T = 1; T <= 10; T++) {
			int strLength = Integer.parseInt(br.readLine());

			String str = br.readLine();
			String[] charArr = { "(", "[", "{", "<" };
			List<String> charList = (Arrays.asList(charArr));

			Stack<String> check = new Stack<String>();
			boolean isValid = true;

			for (int i = 0; i < str.length(); i++) {

				String bracket = Character.toString(str.charAt(i));

				if (charList.contains(bracket)) {
					check.push(bracket);
				} else {
					if (bracket.equals(")")) {
						if (check.peek().equals("(")) {
							check.pop();
						} else {
							isValid = false;
							break;
						}
					} else if (bracket.equals("]")) {
						if (check.peek().equals("[")) {
							check.pop();
						} else {
							isValid = false;
							break;
						}
					} else if (bracket.equals("}")) {
						if (check.peek().equals("{")) {
							check.pop();
						} else {
							isValid = false;
							break;
						}
					} else if (bracket.equals(">")) {
						if (check.peek().equals("<")) {
							check.pop();
						} else {
							isValid = false;
							break;
						}
					}
				}
			}

			int answer = 0;

			if (isValid) {
				answer = 1;
			}

			bw.write("#" + String.valueOf(T) + " " + String.valueOf(answer) + "\n");

		}

		bw.flush();
		bw.close();
	}
}
