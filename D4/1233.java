import java.io.*;
import java.util.*;

class Node {
	int level;
	Node left;
	Node right;
	String data;

	Node(int level) {
		this.level = level;
		this.data = " ";
		left = null;
		right = null;
	}
}

class Tree {
	public Node root;

	public void createNode(int level, int leftData, int rightData, String data) {
		if (root == null) {
			root = new Node(level);
			root.data = data;
			root.left = leftData != -1 ? new Node(leftData) : null;
			root.right = rightData != -1 ? new Node(rightData) : null;

		} else {
			searchNode(root, level, data, leftData, rightData);
		}
	}

	public void searchNode(Node node, int level, String data, int leftData, int rightData) {
		if (node == null) {
			return;
		} else if (node.level == level) {
			node.data = data;
			node.left = leftData != -1 ? new Node(leftData) : null;
			node.right = rightData != -1 ? new Node(rightData) : null;
		} else {
			searchNode(node.left, level, data, leftData, rightData);
			searchNode(node.right, level, data, leftData, rightData); 
		}
	}

	public void inOrder(Node node, List<String> sik) {
		if (node != null) {
			if (node.left != null) {
				inOrder(node.left,sik);
			}
			
			sik.add(node.data);
			
			if (node.right != null) {
				inOrder(node.right,sik);
			}	
		}
	}

}

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int T = 1; T <= 10; T++) {
			int N = Integer.parseInt(br.readLine());
			Tree tree = new Tree();

			for (int i = 0; i < N; i++) {
				int level = 0;
				String value= "";
				int left = -1;
				int right = -1;
				String[] info = br.readLine().split(" ");
				switch (info.length) {
				case 2:
					level = Integer.parseInt(info[0]);
					value = info[1];
					tree.createNode(level, left, right, value);
					break;
				case 3:
					level = Integer.parseInt(info[0]);
					value = info[1];
					left = Integer.parseInt(info[2]);
					tree.createNode(level, left, right, value);
					break;
				case 4:
					level = Integer.parseInt(info[0]);
					value = info[1];
					left = Integer.parseInt(info[2]);
					right = Integer.parseInt(info[3]);
					tree.createNode(level, left, right, value);
					break;
				}
			}
			
			List<String> sik = new ArrayList();
			tree.inOrder(tree.root,sik);
			
			boolean isSik = true;
			
			for (int i = 0; i < sik.size(); i++) {
				String value = sik.get(i);
				if (i == 0) {
					if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {
						isSik = false;
						break;
					}	
				}else {
					String pop = sik.get(i-1);
					if (pop.equals("+") || pop.equals("-") || pop.equals("*") || pop.equals("/")) {
						if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {
							isSik = false;
							break;
						}
					}else {
						if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {
							continue;
						}else {
							isSik = false;
							break;
						}
					}
				}
			}
			
			if (isSik) {
				bw.write("#"+String.valueOf(T)+" 1\n");
			}else {
				bw.write("#"+String.valueOf(T)+" 0\n");
			}
		
		}

		bw.flush();
		bw.close();
	}

}
