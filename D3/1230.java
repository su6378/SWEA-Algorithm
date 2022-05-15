package Main;

import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			int N = sc.nextInt();
			List<Integer> passwords = new LinkedList<>();
            for(int j = 0; j<N; j++){
            	passwords.add(sc.nextInt());
            }
			
			int commands = sc.nextInt();

			for (int j = 0; j < commands; j++) {
				char c = sc.next().charAt(0);
				if (c == 'I') {
					int X = sc.nextInt();
					int Y = sc.nextInt();
					int cnt = X + Y;
					for (int k = X; k < cnt; k++) {
						passwords.add(k, sc.nextInt());
					}
				} else if (c == 'D') {
					int X = sc.nextInt();
					int Y = sc.nextInt();
					int cnt = X + Y;
					for (int k = X; k < cnt; k++) {
						passwords.remove(X);
					}
				} else {
					int Y = sc.nextInt();
					for (int k = 0; k < Y; k++) {
						passwords.add(sc.nextInt());
					}
				}
			}
			for(int j=0; j<10; j++){
                sb.append(passwords.get(j)).append(" ");
            }
            sb.append("\n");
		}
		System.out.println(sb);
	}
}
