import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		for (int tc= 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			List<Integer> code = new ArrayList<>();
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				code.add(Integer.parseInt(token.nextToken()));
			}
			
			int command_length = Integer.parseInt(br.readLine());
			StringTokenizer token2 = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < command_length; i++) {
				String command = token2.nextToken();
				if (command.charAt(0) == 'I') {
					int x = Integer.parseInt(token2.nextToken());
					int y = Integer.parseInt(token2.nextToken());
					for (int j = 0; j < y; j++) {
						int s = Integer.parseInt(token2.nextToken());
						code.add(x,s);
						x++;
					}
				}else if (command.charAt(0) == 'D') {
					int x = Integer.parseInt(token2.nextToken());
					int y = Integer.parseInt(token2.nextToken());
					for (int j = 0; j < y; j++) {
						code.remove(x);
					}
				}
			}
			
			bw.write("#"+String.valueOf(tc)+" ");
			
			for (int i = 0; i < 10; i++) {
				bw.write(code.get(i)+" ");
			}
			
			bw.write("\n");
			
		}
		bw.flush();
		bw.close();
	}
}


