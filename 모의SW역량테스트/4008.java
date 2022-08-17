import java.io.*;
import java.util.*;

public class Solution {

	static int N;
	static int[] opArr;
	static Stack<Integer> opStack;
	static boolean[] visited;
	static HashSet<Integer> set;
	static List<Integer> cards;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tCount = Integer.parseInt(br.readLine());

		for (int T = 1; T <= tCount; T++) {

			N = Integer.parseInt(br.readLine());

			StringTokenizer token = new StringTokenizer(br.readLine());
			opArr = new int[4];
			opStack = new Stack<Integer>();
			visited = new boolean[N - 1];

			for (int i = 0; i < 4; i++) {
				opArr[i] = Integer.parseInt(token.nextToken());
			}

			cards = new ArrayList<>();
			token = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				cards.add(Integer.parseInt(token.nextToken()));
			}

			set = new HashSet<>();

			combination(0);
			
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			
			for (Integer i : set) {
				max = Math.max(max,i);
				min = Math.min(min,i);
			}
			
			int answer = max - min;
			
			bw.write("#"+String.valueOf(T)+" "+String.valueOf(answer)+"\n");

		}

		bw.flush();
		bw.close();
	}

	static void combination(int size) {

		if (size == N - 1) {
			set.add(calculate());
			return;
		}

		for (int i = 0; i < opArr.length; i++) {
			if (opArr[i] > 0 ) {
				opStack.push(i);
				opArr[i] -= 1;
				combination(size + 1);
				opStack.pop();
				opArr[i] += 1; 
			}
		}
	}

	static int calculate() {
		int result = cards.get(0);

		for (int i = 0; i < opStack.size(); i++) {
			switch (opStack.get(i)) {
			case 0:
				result += cards.get(i+1);
				break;
			case 1:
				result -= cards.get(i+1);
				break;
			case 2:
				result *= cards.get(i+1);
				break;
			case 3:
				result /= cards.get(i+1);
				break;
			}
		}
		return result;
	}
}
