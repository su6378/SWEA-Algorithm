import java.util.*;

class UserSolution {
    class News implements Comparable<News> {

        int time;
        int nId;
        int cId;
        boolean isCancel;

        public News(int time, int nId, int cId, boolean isCancel) {
            this.time = time;
            this.nId = nId;
            this.cId = cId;
            this.isCancel = isCancel;
        }

        @Override
        public int compareTo(News o) {
            if (this.time == o.time) {
                return Integer.compare(this.nId, o.nId);
            }
            return Integer.compare(this.time, o.time);
        }

        @Override
        public String toString() {
            return "News{" +
                    "time=" + time +
                    ", nId=" + nId +
                    ", cId=" + cId +
                    ", isCancel=" + isCancel +
                    '}';
        }
    }

    final int USER_SIZE = 500;
    final int NEWS_SIZE = 30000;
    final int CHANNEL_SIZE = 500;
    HashMap<Integer, Integer> userMap;
    HashMap<Integer, Integer> channelMap;
    HashMap<Integer, Integer> newsMap;
    PriorityQueue<News> pq;

    List<News>[] userList;
    News[] newsList;
    List<Integer>[] channelList;
    int uIdx, nIdx, cIdx;

    void init(int N, int K) {
        userMap = new HashMap<>();
        channelMap = new HashMap<>();
        newsMap = new HashMap<>();
        pq = new PriorityQueue<>();
        uIdx = nIdx = cIdx = 0;
        userList = new ArrayList[USER_SIZE];
        newsList = new News[NEWS_SIZE];
        channelList = new ArrayList[CHANNEL_SIZE];

        for (int i = 0; i < USER_SIZE; i++) {
            userList[i] = new ArrayList<>();
        }

        for (int i = 0; i < CHANNEL_SIZE; i++) {
            channelList[i] = new ArrayList<>();
        }
    }

    void registerUser(int mTime, int mUID, int mNum, int mChannelIDs[]) {
        updateTime(mTime);
        int uId;

        if (!userMap.containsKey(mUID)) { // 아이디가 1,000,000,000까지 갈 수 있으므로 map 사용
            uId = uIdx++;
            userMap.put(mUID, uId);
            userList[uId] = new ArrayList<>();
        } else {
            uId = userMap.get(mUID);
        }


        for (int i = 0; i < mNum; i++) {
            int cId;
            if (!channelMap.containsKey(mChannelIDs[i])) { // 채널도 동일
                cId = cIdx++;
                channelMap.put(mChannelIDs[i], cId);
            } else cId = channelMap.get(mChannelIDs[i]);

            channelList[cId].add(uId);
        }
    }

    int offerNews(int mTime, int mNewsID, int mDelay, int mChannelID) {
        int cId = channelMap.get(mChannelID);
        int nId;

        if (!newsMap.containsKey(mNewsID)) { // 뉴스 아이디도 1,000,000,000까지이므로 map 사용
            nId = nIdx++;
            newsMap.put(mNewsID, nId);
        } else nId = newsMap.get(mNewsID);

        newsList[nId] = new News(mTime + mDelay, mNewsID, cId, false);
        pq.add(newsList[nId]);

        // 채널리스트에 해당 채널 아이디를 구독하고 있는 유저 갯수 반환
        return channelList[cId].size();
    }

    void cancelNews(int mTime, int mNewsID) {
        newsList[newsMap.get(mNewsID)].isCancel = true;
    }

    int checkUser(int mTime, int mUID, int mRetIDs[]) {
        updateTime(mTime);

        int uId = userMap.get(mUID);
        int receiveCnt = userList[uId].size();
        int idx = 0;
        for (int i = userList[uId].size() - 1; i >= 0; i--) {
            if (userList[uId].get(i).isCancel) { // 취소된 뉴스이면 받은 알림 갯수 --
                receiveCnt--;
            } else if (idx < 3) { // 최신으로 받은 3개 추출
                mRetIDs[idx++] = userList[uId].get(i).nId;
            }
        }

        // 알림 갯수 0으로 초기화
        userList[uId].clear();

        return receiveCnt;
    }

    // 뉴스가 들어올 때 시간을 체크하고 시간을 만족할 경우 뉴스가 취소되지 않을 경우 구독한 사람들에게 전송
    void updateTime(int mTime) {
        while (!pq.isEmpty()) {
            News now = pq.peek();

            // mTime 시각에 유저에게 보내지는 뉴스 알림이 있는 경우 먼저 알림을 보낸 후, mUID 유저를 뉴스 채널에 등록한다.
            if (now.time > mTime) {
                return;
            }

            pq.poll();

            if (now.isCancel) continue; // 취소되었으면 사용자에게 전송 X

            // now에 있는 채널 정보에 저장되어있는 uID에 전송
            for (int i = 0; i < channelList[now.cId].size(); i++) {
                userList[channelList[now.cId].get(i)].add(now);
            }
        }
    }
}