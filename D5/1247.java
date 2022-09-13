import java.io.*;
import java.util.*;


public class Solution {
	
	static int[][] customers;
	static int homeX;
	static int homeY;
	static boolean[] visited; //방문 중복 체크 배열
	static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			//회사 좌표
			int companyX = Integer.parseInt(token.nextToken()); 
			int companyY = Integer.parseInt(token.nextToken());
			
			//집 좌표
			homeX = Integer.parseInt(token.nextToken());
			homeY = Integer.parseInt(token.nextToken());
			
			//N명의 고객 좌표
			customers = new int[N][2];
			
			for (int i = 0; i < N; i++) {
				customers[i][0] = Integer.parseInt(token.nextToken());
				customers[i][1] = Integer.parseInt(token.nextToken());				
			}
			
			visited = new boolean[N];
			min = Integer.MAX_VALUE; //최솟값 반복문 실행시마다 초기화
			
			visit(0,N,companyX,companyY,0); //방문 조합 시작
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(min)+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	static void visit(int index, int size, int currentX, int currentY,int distance) {
		if (index == size) { //다 방문했을 때
			distance += Math.abs(currentX - homeX) + Math.abs(currentY - homeY); //마지막으로 집에 오는 거리++
			min = Math.min(min,distance); //최솟값 갱신
			return;
		}
		
		for (int i = 0; i < customers.length; i++) {
			if (!visited[i]) {
				distance += Math.abs(currentX - customers[i][0]) + Math.abs(currentY - customers[i][1]); //거리갱신
				if (distance < min) { //백트래킹 (이 조건을 안 걸어주니깐 실행시간 1000ms넘어감 근데 이 문제는 완전탐색으로 풀으라고 해서 이 조건을 없애도 통과)
					visited[i] = true;
					visit(index+1,size,customers[i][0],customers[i][1],distance);
					visited[i] = false;
				}
				distance -= Math.abs(currentX - customers[i][0]) + Math.abs(currentY - customers[i][1]); //거리되돌리기
			}
		}
	}
}
