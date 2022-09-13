import java.io.*;
import java.util.*;

public class Solution2 {

	static List<Integer>[] graph; // 그래프
	static List<Integer> parent1;
	static List<Integer> parent2;
	static boolean[] visited1;
	static boolean[] visited2;
	static int parent;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(token.nextToken());
			int E = Integer.parseInt(token.nextToken());

			int v1 = Integer.parseInt(token.nextToken());
			int v2 = Integer.parseInt(token.nextToken());

			graph = new ArrayList[V + 1];

			for (int i = 1; i <= V; i++) {
				graph[i] = new ArrayList();
			}

			token = new StringTokenizer(br.readLine());

			for (int i = 0; i < E; i++) {
				graph[Integer.parseInt(token.nextToken())].add(Integer.parseInt(token.nextToken()));
			}

			// 양 쪽 정점들의 부모 노드들의 리스트
			parent1 = new ArrayList();
			parent2 = new ArrayList();

			// 양 쪽 정점들의 방문 체크 배열 초기화
			visited1 = new boolean[V + 1];
			visited2 = new boolean[V + 1];

			parent = -1; // 공통부모 초기화
			search(v1, v2); // 공통부모 찾기

			count = 0; // 서브트리의 크기
			subTree(parent);

			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(parent) + " " + String.valueOf(count) + "\n");
		}
		bw.flush();
		bw.close();
	}

	static void search(int v1, int v2) { // 공통 부모노드 찾기
		if (!parent1.isEmpty()) {
			int value = checking();
			if (value != -1) {
				parent = value;
				return;
			}
		}

		if (v1 != 1) { // 1이면 루트노드이므로 더이상 검색할 필요없으므로 continue
			for (int i = 1; i < graph.length; i++) {
				boolean isSearch = false;
				if (!visited1[i]) { //이미 자식노드 일 경우 탐색할 필요없으므로 continue
					for (Integer node : graph[i]) {
						if (node == v1) {
							parent1.add(i);
							v1 = i;
							visited1[i] = true;
							isSearch = true;
							break;
						}
					}
					if (isSearch) {
						break;
					}
				}
			}
		}

		if (v2 != 1) {
			for (int i = 1; i < graph.length; i++) {
				if (!visited2[i]) {
					boolean isSearch = false;
					for (Integer node : graph[i]) {
						if (node == v2) {
							parent2.add(i);
							v2 = i;
							visited2[i] = true;
							isSearch = true;
							break;
						}
					}
					if (isSearch) {
						break;
					}
				}
			}
		}

		search(v1, v2);

	}

	static int checking() { // 서로 하나씩 올라가면서 리스트에 추가 후 부모가 같으면 부모 값 갱신시키고 빠쪄 나오기
		int value = -1;
		for (int i = 0; i < parent1.size(); i++) {
			for (int j = 0; j < parent2.size(); j++) {
				int value1 = parent1.get(i); //value1 안넣으니깐 계속 루트 1값이 나옴 그래서 value1변수안에 값을 담아둠.
				int value2 = parent2.get(j);
				if (value1 == value2) {
					value = parent1.get(i);
					return value;
				}
			}
		}
		return value;
	}

	static void subTree(int node) { //서브트리 크기 구하기 bfs
		Queue<Integer> queue = new LinkedList();
		queue.add(node);
		count++;

		while (!queue.isEmpty()) {
			int qPoll = queue.poll();

			for (Integer child : graph[qPoll]) {
				queue.add(child);
				count++;
			}
		}
	}
}
