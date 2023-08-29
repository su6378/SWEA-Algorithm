class Node {
    Node prev, next;
    int minValue;
    int maxValue;
    int[] nums;
    int size;

    void init(Node p, Node n) {
        size = 0;
        prev = p;
        next = n;
        minValue = Integer.MAX_VALUE;
        maxValue = Integer.MIN_VALUE;
        nums = new int[450];
    }

    void add(int num) {
        nums[size++] = num;
        minValue = Math.min(minValue, num);
        maxValue = Math.max(maxValue, num);
    }

    // 값이 추가되거나 삭제 되었을때 최솟값, 최댓값 갱신
    void update() {
        minValue = Integer.MAX_VALUE;
        maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            minValue = Math.min(minValue, nums[i]);
            maxValue = Math.max(maxValue, nums[i]);
        }
    }

}

class UserSolution {

    Node head;
    Node tail;
    int lastIdx;
    Node[] nodes;
    final int MAX_SIZE = 450;

    public void init(int N, int[] arr) {
        lastIdx = 0;
        nodes = new Node[MAX_SIZE];
        head = new Node();
        tail = new Node();
        nodes[0] = new Node();
        nodes[0].init(head, tail);
        head.next = nodes[0];
        tail.prev = nodes[0];

        add(N, arr);
    }

    public void add(int M, int[] arr) {
        for (int i = 0; i < M; i++) {
            if (tail.prev.size >= MAX_SIZE) {
                nodes[++lastIdx] = new Node();
                nodes[lastIdx].init(tail.prev, tail);
                tail.prev.next = nodes[lastIdx];
                tail.prev = nodes[lastIdx];
            }
            tail.prev.add(arr[i]);
        }
    }

    public void erase(int from, int to) {
        from -= 1;
        to = to - from;
        Node node = head.next;

        while (from >= node.size) { // 시작 구간 찾기
            from -= node.size;
            node = node.next;
        }

        while (to > 0 && node.size - from <= to) { // 해당 인덱스 삭제
            to -= node.size - from;
            node.size = from;
            node.update();

            if (node.size == 0) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            node = node.next;
            from = 0;
        }

        if (to > 0) { // 삭제한 인덱스 뒤에 데이터가 있어서 댕겨와서 최솟값과 최댓값 다시 갱신
            if (node.prev != head && node.prev.size + node.size - to <= MAX_SIZE) {
                for (int i = 0; i < from; i++) {
                    node.prev.add(node.nums[i]);
                }
                for (int i = from + to; i < node.size; i++) {
                    node.prev.add(node.nums[i]);
                }
                node.prev.next = node.next;
                node.next.prev = node.prev;
            } else {
                for (int i = from + to; i < node.size; i++) {
                    node.nums[i - to] = node.nums[i];
                }
                node.size -= to;
                node.update();
            }
        }
    }

    public int find(int K) {
        Node node = tail.prev;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        while (true) {
            if (node.size >= K) { // 범위 지정해서 계산
                for (int i = node.size - K; i < node.size; i++) {
                    minValue = Math.min(minValue, node.nums[i]);
                    maxValue = Math.max(maxValue, node.nums[i]);
                }
                break;
            } else { // 각 size를 가진 배열에서 이미 구해진 최솟값 최댓값으로 갱신
                minValue = Math.min(minValue, node.minValue);
                maxValue = Math.max(maxValue, node.maxValue);
                K -= node.size;
            }
            node = node.prev;
        }
        return maxValue - minValue;
    }
}