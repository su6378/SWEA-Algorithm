import java.io.*;
import java.util.*;

public class Solution {
	
	static Set<String> set; // 문자열 조합
	static String str;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			str = br.readLine();
			
			set = new HashSet<>();
			
			makeWord(); //단어 만들기
			
			List<String> list = new ArrayList<String>();
			
			for (String string : set) { //정렬하기 위해 리스트에 삽입
				list.add(string);
			}
			
			Collections.sort(list); //정렬
			
			bw.write("#"+String.valueOf(tc)+" ");
			
			if (list.size() < K) { //사이즈가 적으면 인덱스를 못찾으므로 none 반환
				bw.write("none\n");
			}else {
				bw.write(String.valueOf(list.get(K-1))+"\n");
			}
		}
		bw.flush();
		bw.close();
	}

	static void makeWord() {
		
		for (int i = 1; i <= str.length(); i++) { //단어 길이 
			for (int j = 0; j+i <= str.length(); j++) { //현재 인덱스에서 + 단어 길이 값이 전체 길이보다 작거나 같은경우까지 탐색
				set.add(str.substring(j,j+i)); // substring으로 부분문자열 만듬.
			}
		}
	}
}
