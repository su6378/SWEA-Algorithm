import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());

			int H = Integer.parseInt(token.nextToken());
			int W = Integer.parseInt(token.nextToken());

			char[][] map = new char[H][W];
			int h = 0;
			int w = 0;
			char dir = 'z';

			for (int i = 0; i < map.length; i++) {
				String component = br.readLine().trim();
				for (int j = 0; j < component.length(); j++) {
					map[i][j] = component.charAt(j);
					if (map[i][j] == '^') {
						h = i;
						w = j;
						dir = '^';
					} else if (map[i][j] == 'v') {
						h = i;
						w = j;
						dir = 'v';
					} else if (map[i][j] == '<') {
						h = i;
						w = j;
						dir = '<';
					} else if (map[i][j] == '>') {
						h = i;
						w = j;
						dir = '>';
					}
				}
			}

			int N = Integer.parseInt(br.readLine());
			String command = br.readLine();
			char[] command_arr = new char[N];

			for (int i = 0; i < command.length(); i++) {
				command_arr[i] = command.charAt(i);
			}

			for (int i = 0; i < command_arr.length; i++) {
				switch (command_arr[i]) {
				case 'S':
					if (dir == '^') {
						int up = 1;
						while (true) {
							if ((h - up) < 0) break;
							else {
								if (map[h-up][w] == '*') {
									map[h-up][w] = '.';
									break;
								} else if (map[h-up][w] == '#') {
									break;
								} else if (map[h-up][w] == '-' || map[h-up][w] == '.') {
									up++;
								}
							}
						}
					} else if (dir == 'v') {
						int down = 1;
						while (true) {
							if ((h + down) > H - 1)
								break;
							else {
								if (map[h+down][w] == '*') {
									map[h+down][w] = '.';
									break;
								} else if (map[h+down][w] == '#') {
									break;
								} else if (map[h+down][w] == '-' || map[h+down][w] == '.') {
									down++;
								}
							}
						}
					} else if (dir == '<') {
						int left = 1;
						while (true) {
							if ((w - left) < 0) break;
							else {
								if (map[h][w-left] == '*') {
									map[h][w-left] = '.';
									break;
								} else if (map[h][w-left] == '#') {
									break;
								} else if (map[h][w-left] == '-' || map[h][w-left] == '.') {
									left++;
								}
							}
						}
					} else if (dir == '>') {
						int right = 1;
						while (true) {
							if ((w + right) > W - 1) break;
							else {
								if (map[h][w+right] == '*') {
									map[h][w+right] = '.';
									break;
								} else if (map[h][w+right] == '#') {
									break;
								} else if (map[h][w+right] == '-' || map[h][w+right] == '.') {
									right++;
								}
							}
						}
					}
					break;
				case 'U':
					dir = '^';
					if(h - 1 >= 0) {
						if (map[h-1][w] == '.') {
							map[h-1][w] = '^';
							map[h][w] = '.';
							h--;
						}else map[h][w] = '^'; 
					}else map[h][w] = '^'; 
					break;
				case 'D':
					dir = 'v';
					if(h + 1 <= H - 1) {
						if (map[h+1][w] == '.') {
							map[h+1][w] = 'v';
							map[h][w] = '.';
							h++;
						}else map[h][w] = 'v'; 
					}else map[h][w] ='v'; 
					break;
				case 'L':
					dir = '<';
					if(w - 1 >= 0) {
						if(map[h][w-1] == '.') {
							map[h][w-1] = '<';
							map[h][w] = '.';
							w--;
						}else map[h][w] = '<'; 
					}else map[h][w] = '<'; 
					break;
				case 'R':
					dir = '>';
					if (w + 1 <= W - 1) {
						if(map[h][w+1] == '.') {
							map[h][w+1] = '>';
							map[h][w] = '.'; 
							w++;
						}else map[h][w] = '>'; 
					}else map[h][w] = '>';
						break;
				}
			}
			bw.write("#"+String.valueOf(tc)+" ");
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					bw.write(String.valueOf(map[i][j]));
				}
				bw.write("\n");
			}

		}
		bw.flush();
		bw.close();
	}
}
