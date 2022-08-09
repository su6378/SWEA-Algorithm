import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int T = 1; T <= 10; T++) {
			int strLength = Integer.parseInt(br.readLine());
			char[] sik = br.readLine().toCharArray();

			StringBuilder sb = new StringBuilder();
			Stack<Character> stack = new Stack<Character>();
			
			for(char c : sik) {
				if (c != '+' && c!= '*' && c != '(' && c != ')') {
					sb.append(c);
				}
				else if(c == '+') {
					while( stack.size() != 0 && stack.peek() != '(') {
						sb.append(stack.pop());
					}
					stack.add(c);
				}
				else if(c == '*') {
					while( stack.size() != 0 && stack.peek() == '*') {
						sb.append(stack.pop());
						}
					stack.add(c);
				}
				else if(c == '(') {
					stack.add(c);
				}
				else if(c == ')') {
					while(stack.peek() != '(') {
						sb.append(stack.pop());
					}
					stack.pop();
				}
			}
			
			while(stack.size() != 0) {
				sb.append(stack.pop());
			}
			
			String sik2 = sb.toString();
			Stack<Integer> stack2 = new Stack<Integer>();
			
			for (int i = 0; i < sik2.length(); i++) {
				char ch = sik2.charAt(i);
				if (ch == '*') {
					int result = stack2.pop() * stack2.pop();
					stack2.push(result);
				}else if(ch == '+') {
					int result = stack2.pop() + stack2.pop();
					stack2.push(result);
				}else {
					stack2.push(ch-'0');
				}
			}
			
			int asnwer = stack2.pop();
			
			bw.write("#"+String.valueOf(T)+" "+String.valueOf(asnwer)+"\n");
		}

		bw.flush();
		bw.close();
	}

}
