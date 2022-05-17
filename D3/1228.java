import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		for (int tc= 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			List<Integer> code = new ArrayList<Integer>();
			
			StringTokenizer original = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				code.add(Integer.parseInt(original.nextToken()));
			}
			
			
			int N2 = Integer.parseInt(br.readLine());
			StringTokenizer cmd = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N2; i++) {
				String command = cmd.nextToken();
				
				if (command.charAt(0) == 'I') {
					int x = Integer.parseInt(cmd.nextToken());
					int y = Integer.parseInt(cmd.nextToken());
					for (int j = 0; j < y; j++) {
						int s = Integer.parseInt(cmd.nextToken());
						code.add(x, s);
						x++;
					}
				}
			}
			
			bw.write("#"+String.valueOf(tc)+" ");
			
			for (int i = 0; i <= 9; i++) {
				bw.write(String.valueOf(code.get(i))+" ");
			}
			
			bw.write("\n");
			
		}
		bw.flush();
		bw.close();
	}
}


