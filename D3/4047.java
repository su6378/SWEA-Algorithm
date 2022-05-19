import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			HashMap<Integer,Integer> spade = new HashMap<Integer,Integer>();
			HashMap<Integer,Integer> diamond = new HashMap<Integer,Integer>();
			HashMap<Integer,Integer> heart = new HashMap<Integer,Integer>();
			HashMap<Integer,Integer> clover = new HashMap<Integer,Integer>();
			boolean error = false;
			for (int i = 0; i < str.length(); i+=3) {
				char shape = str.charAt(i);
				int number = Integer.valueOf(str.substring(i+1,i+3));
				if (shape == 'S') {
					if (spade.containsKey(number)) {
						error = true;
						break;
					}else spade.put(number,1);
				}else if(shape == 'D') {
					if (diamond.containsKey(number)) {
						error = true;
						break;
					}else diamond.put(number,1);
				}else if(shape == 'H') {
					if (heart.containsKey(number)) {
						error = true;
						break;
					}else heart.put(number,1);
				}else {
					if (clover.containsKey(number)) {
						error = true;
						break;
					}else clover.put(number,1);
				}
			}
			
			bw.write("#"+String.valueOf(tc)+" ");
			if(error) bw.write(String.valueOf("ERROR\n"));
			else {
				bw.write(String.valueOf(13 - spade.size())+" ");
				bw.write(String.valueOf(13 - diamond.size())+" ");
				bw.write(String.valueOf(13 - heart.size())+" ");
				bw.write(String.valueOf(13 - clover.size())+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
}

