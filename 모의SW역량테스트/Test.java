import java.io.*;
import java.util.*;


public class Test {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		String[] hexa = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010",
				"1011", "1100", "1101", "1110", "1111" };

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());

			HashSet<String> set = new HashSet();
			HashSet<String> binarySet = new HashSet();
			HashSet<String> patternSet = new HashSet();

			for (int i = 0; i < N; i++) {

				String passCode = br.readLine().trim();

				StringBuilder patterSb = new StringBuilder();
				StringBuilder tempSb = new StringBuilder();
				
				int start = 0;

				for (int j = 0; j < passCode.length(); j++) {
					if (passCode.charAt(j) != '0') {
						start = j;
						break;
					}
				}
				boolean flag = false;
				boolean exist = false;
				for (int j = passCode.length() - 1; j >= start; j--) {
					if (patternSet.isEmpty()) {
						if (passCode.charAt(j) != '0') {
							tempSb.insert(0, passCode.charAt(j));
							flag = true;
							exist = true;
						} else {
							if (flag) {
								tempSb.insert(0, passCode.charAt(j));
							}
						}
					} else {
						if (passCode.charAt(j) != '0') {
							tempSb.insert(0, passCode.charAt(j));
							flag = true;
							exist = true;
						} else {
							if (flag) {
								boolean isEqual = false;
								for (String pattern : patternSet) {
									//System.out.println(tempSb.toString());
									if (pattern.equals(tempSb.toString())) {
										isEqual = true;
										break;
									}
								}
								if (isEqual) {
									flag = false;
									tempSb.setLength(0);
									exist = false;
								}else {
									
									tempSb.insert(0, passCode.charAt(j));
								}
							}
						}
					}

				}
				
				if (exist) {
					if (patternSet.isEmpty()) {
						patternSet.add(tempSb.toString());
					}else {
						StringBuilder checkSb = new StringBuilder();
						boolean check = false;
						String temp = tempSb.toString();
						for (int j = 0; j < temp.length(); j++) {
							if (temp.charAt(j) != '0') {
								check = true;
								checkSb.append(temp.charAt(j));
								exist = true;
							}
							
							if (check) {
								if (temp.charAt(j) == '0') {
									boolean isEqual = false;
									for (String pattern : patternSet) {
										if (checkSb.toString().equals(pattern)) {
											isEqual = true;
											break;
										}
									}
									if (isEqual) {
										checkSb.setLength(0);
										check = false;
										exist = false;
									}else {
										checkSb.append('0');
									}
								}
							}
						}
						
						if (exist) {
							patternSet.add(checkSb.toString());
						}
					}
				}
				
			}
			System.out.println(patternSet);
			
			boolean exist = false;
			HashSet<String> tempSet = new HashSet();
			HashSet<String> deleteSet = new HashSet();
			for (String pattern : patternSet) {
				int count = 0;
				boolean chekcing = false;
				for (int i = 0; i < pattern.length(); i++) {
					if (pattern.charAt(i) == '0') {
						count++;
					}else {
						count = 0;
					}
					
					if (count == 4) {
						chekcing = true;
					}
				}
				if (chekcing) {
					deleteSet.add(pattern);
					StringBuilder lastSb = new StringBuilder();
					boolean check = false;
					for (int i = 0; i < pattern.length(); i++) {
						
						if (pattern.charAt(i) != '0') {
							lastSb.append(pattern.charAt(i));
							check = true;
							exist = true;
						}
						
						if (check) {
							if (pattern.charAt(i) == '0') {
								boolean isEqual = false;
								for (String str : patternSet) {
									if (str.equals(lastSb.toString())) {
										isEqual = true;
									}
								}
								
								if (isEqual) {
									lastSb.setLength(0);
									check = false;
									exist = false;
								}else {
									lastSb.append('0');
								}
							}
						}
					}
					
					if (exist) {
						tempSet.add(lastSb.toString());
					}
				}
				
			}
			
			for (String temp : tempSet) {
				patternSet.add(temp);
			}
			
			for (String delete : tempSet) {
				patternSet.remove(delete);
			}
			
			for (String hexaCode : patternSet) {
				StringBuilder binarySb = new StringBuilder();

				for (int i = 0; i < hexaCode.length(); i++) {
					binarySb.append(hexa[Character.getNumericValue(hexaCode.charAt(i))]);
				}

				String binaryCode = binarySb.toString();
				int last = -1;

				for (int i = binaryCode.length() - 1; i >= 0; i--) {
					if (binaryCode.charAt(i) == '1') {
						last = i;
						break;
					}
				}
				
				int power = (binaryCode.length() / 56);
				int diff1 = Math.abs((56*power) - last - 1);
				int diff2 = Math.abs((56*(power+1)) - last - 1);
				
				if (diff2 < diff1) {
					power++;
				}
				
				if ((last + 1) < 56 * power) {
					int diff = (56 * power) - last - 1;
					last += diff;
					for (int i = 0; i < diff; i++) {
						binarySb.insert(0, '0');
					}
					binaryCode = binarySb.toString();
				}
				power = binaryCode.length() / 56;
				
				StringBuilder passSb = new StringBuilder();
				for (int k = last - (56 * power) + 1; k <= last; k += 7 * power) {

					StringBuilder sb = new StringBuilder();
					for (int a = k; a < k + 7 * power; a++) {
						sb.append(binaryCode.charAt(a));
					}

					int number = change(sb.toString(), power);
					passSb.append(number);
				}

				set.add(passSb.toString());

			}
			
			int answer = 0;
			for (String password : set) {
				int holsu = 0;
				int jjaksu = 0;
				int sum = 0;
				for (int i = 0; i < password.length(); i++) {
					sum += Character.getNumericValue(password.charAt(i));
				}

				for (int i = 0; i < password.length(); i += 2) {
					holsu += Character.getNumericValue(password.charAt(i));
				}

				holsu *= 3;

				for (int i = 1; i < password.length(); i += 2) {
					jjaksu += Character.getNumericValue(password.charAt(i));
				}

				int result = holsu + jjaksu;

				if (result % 10 == 0) {
					answer += sum;
				}
			}
			bw.write("#" + String.valueOf(tc) + " " + String.valueOf(answer) + "\n");

		}
		bw.flush();
		bw.close();

	}

	static int change(String sb, int power) {
		int number = -1;
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		boolean start = true;
		boolean isA = true;
		boolean isB = true;
		for (int i = 0; i < sb.length(); i++) {
			if (start) {
				if (isA && sb.charAt(i) == '1') {
					a = i;
					isA = false;
					start = false;
				} else if (!isA && sb.charAt(i) == '1') {
					c = i - a - b;
					start = false;
				}
			} else {
				if (isB && sb.charAt(i) == '0') {
					b = i - a;
					isB = false;
					start = true;
				}
			}
		}

		d = sb.length() - a - b - c;

		a /= power;
		b /= power;
		c /= power;
		d /= power;

		//System.out.println(sb + " " + a + " " + b + " " + c + " " + d);

		if (a == 3 && b == 2 && c == 1 && d == 1) {
			number = 0;
		} else if (a == 2 && b == 2 && c == 2 && d == 1) {
			number = 1;
		} else if (a == 2 && b == 1 && c == 2 && d == 2) {
			number = 2;
		} else if (a == 1 && b == 4 && c == 1 && d == 1) {
			number = 3;
		} else if (a == 1 && b == 1 && c == 3 && d == 2) {
			number = 4;
		} else if (a == 1 && b == 2 && c == 3 && d == 1) {
			number = 5;
		} else if (a == 1 && b == 1 && c == 1 && d == 4) {
			number = 6;
		} else if (a == 1 && b == 3 && c == 1 && d == 2) {
			number = 7;
		} else if (a == 1 && b == 2 && c == 1 && d == 3) {
			number = 8;
		} else if (a == 3 && b == 1 && c == 1 && d == 2) {
			number = 9;
		}

		return number;
	}
}
