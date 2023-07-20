class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class UserSolution {

    private final static int MAX_NODE = 10000;

    private Node[] node = new Node[MAX_NODE];
    private int nodeCnt = 0;
    private Node head;

    public Node getNode(int data) {
        node[nodeCnt] = new Node(data);
        return node[nodeCnt++];
    }

    public void init() { // 리스트를 초기화
        head = null;
        nodeCnt = 0;
    }

    public void addNode2Head(int data) {
        Node newNode = getNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void addNode2Tail(int data) {
        Node newNode = getNode(data);
        if (head == null) head = newNode; // 초기 상태일때는 head가 null이다.
        else{
            Node curNode = head;
            while (curNode.next != null){ // 다음 노드가 null인 곳에 newNode를 삽입
                curNode = curNode.next;
            }
            curNode.next = newNode;
        }
    }

    public void addNode2Num(int data, int num) {
        if (num == 1){ // 맨 처음 인덱스에 삽입할 때
            addNode2Head(data);
            return;
        }

        Node newNode = getNode(data);
        Node curNode = head;
        int idx = 1;

        while (curNode != null && idx < num-1){
            curNode = curNode.next;
            idx++;
        }

        if (curNode != null){
            newNode.next = curNode.next;
            curNode.next = newNode;
        }
    }

    public void removeNode(int data) {
        if (head == null) return; // 헤드가 비어있으면 종료

        if (head.data == data){ // 현재 헤드 데이터가 삭제할 데이터면 다음 노드로 바꾸고 종료
            head = head.next;
            return;
        }

        Node curNode = head;
        while (curNode.next != null){
            if (curNode.next.data == data){ // 다음 데이터가 삭제할 데이터면 next를 삭제할 데이터 다음 노드로 갱신
                curNode.next = curNode.next.next;
                return;
            }
            curNode = curNode.next;
        }
    }

    public int getList(int[] output) {
        int idx = 0; // 탐색할 인덱스
        Node curNode = head;

        // 현재 노드가 null이 아니고 MAX_NODE 사이즈까지 output에 데이터를 넣어준다.
        while (curNode != null && idx < MAX_NODE){
            output[idx++] = curNode.data;
            curNode = curNode.next;
        }
        return idx;
    }
}