class Node {
    public int data;
    public Node prev;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
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

    public void init() {
        head = null;
        nodeCnt = 0;
    }

    public void addNode2Head(int data) {
        Node newNode = getNode(data);

        if (head != null) { // 현재 노드에 prev에 새로운 노드 연결
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
    }

    public void addNode2Tail(int data) {
        Node newNode = getNode(data);

        if (head == null) {
            head = newNode;
        } else {
            Node curNode = head;
            while (curNode.next != null) {
                curNode = curNode.next;
            }
            curNode.next = newNode;
            newNode.prev = curNode;
        }
    }

    public void addNode2Num(int data, int num) {
        if (num == 1) {
            addNode2Head(data);
            return;
        }

        Node newNode = getNode(data);
        Node curNode = head;
        int idx = 1;

        while (curNode != null && idx < num - 1){
            curNode = curNode.next;
            idx++;
        }

        if (curNode != null){
            newNode.prev = curNode;
            newNode.next = curNode.next;

            if (curNode.next != null){
                curNode.next.prev = newNode;
            }
            curNode.next = newNode;
        }
    }

    public int findNode(int data) {
        int idx = 1;
        Node curNode = head;

        while (curNode != null){
            if (curNode.data == data){
                return idx;
            }
            curNode = curNode.next;
            idx++;
        }
        return -1;
    }

    public void removeNode(int data) {
        if (head == null) return;

        if (head.data == data){
            head = head.next;
            if (head != null){ // 삭제할 데이터 다음 노드로 바꿔주고 prev에 연결된 노드는 끊기
                head.prev = null;
            }
            return;
        }

        Node curNode = head;

        while (curNode != null){
            if (curNode.data == data){
                if (curNode.prev != null){ // 현재 데이터 연결 끊고 다음 데이터로 연결시키기
                    curNode.prev.next = curNode.next;
                }
                if (curNode.next != null){
                    curNode.next.prev = curNode.prev;
                }
                return;
            }
            curNode = curNode.next;
        }
    }

    public int getList(int[] output) {
        int idx = 0;
        Node curNode = head;

        while (curNode != null && idx < MAX_NODE){
            output[idx++] = curNode.data;
            curNode = curNode.next;
        }
        return idx;
    }

    public int getReversedList(int[] output) {
        int idx = 0;
        Node curNode = head;

        while (curNode != null && idx < MAX_NODE){
            output[idx++] = curNode.data;
            curNode = curNode.next;
        }

        int s = 0;
        int e = idx - 1;

        while (s < e){
            int tmp = output[s];
            output[s] = output[e];
            output[e] = tmp;
            s++;
            e--;
        }
        return idx;
    }
}