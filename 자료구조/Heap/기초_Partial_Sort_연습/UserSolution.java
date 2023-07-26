public class UserSolution {
    public static final int MAX_SIZE = 1000001;

    public static class User {
        int uId;
        int income;

        public User(int uId, int income) {
            this.uId = uId;
            this.income = income;
        }
    }


    public static class Heap {
        User[] heap = new User[MAX_SIZE];
        int hCnt = 0;

        public Heap() {
        }

        public void push(User user) {
            heap[++hCnt] = user;
            int idx = hCnt;
            while (idx > 1 && (heap[idx / 2].income < heap[idx].income || (heap[idx / 2].income == heap[idx].income
                    && heap[idx / 2].uId > heap[idx].uId))) {
                User tmp = heap[idx / 2];
                heap[idx / 2] = heap[idx];
                heap[idx] = tmp;
                idx /= 2;
            }
        }

        public User pop() {
            User pop = heap[1];
            heap[1] = heap[hCnt--];
            int idx = 1;
            int next;
            while (true) {
                next = idx * 2;
                if (next < hCnt && (heap[next].income < heap[next + 1].income
                        || (heap[next].income == heap[next + 1].income && heap[next].uId > heap[next + 1].uId)))
                    next++;
                if (next > hCnt || (heap[next].income < heap[idx].income
                        || (heap[next].income == heap[idx].income && heap[next].uId > heap[idx].uId)))
                    break;
                User tmp = heap[idx];
                heap[idx] = heap[next];
                heap[next] = tmp;
                idx = next;
            }
            return pop;
        }
    }

    Heap maxHeap;

    public void init() {
        maxHeap = new Heap();
        maxHeap.hCnt = 0;
    }

    public void addUser(int uID, int income) {
        maxHeap.push(new User(uID, income));
    }

    int getTop10(int[] result) {
        int size;

        if (maxHeap.hCnt < 10) size = maxHeap.hCnt;
        else size = 10;

        User[] tmp = new User[size];

        for (int i = 0; i < size; i++) {
            User user = maxHeap.pop();
            result[i] = user.uId;
            tmp[i] = user;
        }

        for (int i = 0; i < size; i++) {
            maxHeap.push(tmp[i]);
        }
        return size;
    }
}