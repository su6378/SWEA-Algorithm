import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] number; //숫자 배열
	static List<Integer> sortNumber; //내림차순 정렬 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			String numberStr = token.nextToken();
			int changeCount = Integer.parseInt(token.nextToken());
			number = new int[numberStr.length()];
			sortNumber = new ArrayList<Integer>();
			
			for (int i = 0; i < number.length; i++) {
				number[i] = Character.getNumericValue(numberStr.charAt(i));
				sortNumber.add(Character.getNumericValue(numberStr.charAt(i)));
			}
			
			Collections.sort(sortNumber,Collections.reverseOrder()); //내림차순 정렬
			
			int target = 0;
			while (true) {
				if (changeCount == 0) break;
				if (target > number.length-1) { //target index가 범위 초과했을 경우에 마지막 index로 초기화
					target = number.length-1;
				}
				int swapIndex = -1; //교환할 인덱스
				if (!isSort()) { //정렬 되어 있지 않은 경우
					if (number[target] != sortNumber.get(target)) { //target index가 내림차순 배열에 인덱스와 일치하면 target++;
						
						for (int i = 0; i < number.length; i++) {
							if (number[i] == sortNumber.get(target)) { //스왑할 인덱스 찾기
								swapIndex = i;
								boolean isLocation = false;
								//target값이 sortNumber배열 숫자에 해당 인덱스가 만약 sortNumber[target]과 일치할 경우 swapIndex가 number배열에 해당 인덱스로 바꿔도 됨
								for (int j = 0; j < sortNumber.size(); j++) { 
									if (number[target] == sortNumber.get(j) && number[j] == sortNumber.get(target)) {
										swapIndex = j;
										isLocation = true;
										break;
									}
								}
								
								if (isLocation) {
									break;
								}
							}
							
						}
						if (swapIndex != -1) { //스왑할 인덱스를 찾으면
							swap(target, swapIndex);
							changeCount--;
							target++;
						}
					}else { 
						target++;
						
					}
				}else {//정렬된 경우
					int[] visited = new int[10];
					int changeIndex = -1;
					for (int i = 0; i < number.length; i++) {
						visited[number[i]]++;
						if (visited[number[i]] > 1) { //같은 숫자가 있으면 같은 숫자끼리 교환하면 되므로 무한loop 탈출
							changeIndex = i;
							changeCount = 0;
							break;
						}
					}
					
					if (changeIndex == -1) { //마지막인덱스와 그전에 인덱스 교환
						swap(number.length-1, number.length-2);
						changeCount--;
					}
				}
			}
			
			bw.write("#"+String.valueOf(tc)+" ");
			for (int i = 0; i < number.length; i++) {
				bw.write(String.valueOf(number[i]));
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	static void swap(int a, int b) {
		int temp;
		temp = number[a];
		number[a] = number[b];
		number[b] = temp; 
	}
	
	static boolean isSort() {
		boolean check = true;
		
		for (int i = 0; i < number.length; i++) {
			if (number[i] != sortNumber.get(i)) {
				check = false;
				break;
			}
		}
		
		return check;
	}

}
