package design;

import java.util.*;

/**
 * @Desc https://leetcode.com/problems/design-twitter/
 * @Author gcc
 * @Date 19-1-6 下午9:41
 **/
public class Twitter {
    //所有对象公用一个timeStamp,方便排序
    public static int timeStamp = 0;
    public Map<Integer, User> map = new HashMap<>();
    /** Initialize your data structure here. */
    public Twitter() {
        map = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!map.containsKey(userId)) {
            map.put(userId, new User(userId));
        }
        map.get(userId).post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if (!map.containsKey(userId)) {
            return res;
        }

        Set<Integer> set = map.get(userId).followeeIds;
        PriorityQueue<Tweet> q = new PriorityQueue<>(set.size(), (a, b) -> (b.time - a.time));
        //将链表放入优先级队列,队头元素一定是最新的
        for (Integer id : set) {
            Tweet t = map.get(id).head;
            if (t != null) {
                q.offer(t);
            }
        }
        int n = 0;
        while (!q.isEmpty() && n < 10) {
            Tweet t = q.poll();
            res.add(t.id);
            n++;
            if (t.next != null) {
                q.offer(t.next);
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!map.containsKey(followerId)){
            User u = new User(followerId);
            map.put(followerId, u);
        }
        if(!map.containsKey(followeeId)){
            User u = new User(followeeId);
            map.put(followeeId, u);
        }
        map.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!map.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        map.get(followerId).unfollow(followeeId);
    }

    class User {
        int id;
        Set<Integer> followeeIds;
        Tweet head;

        User(int id) {
            this.id = id;
            followeeIds = new HashSet<>();
            //关注自己
            follow(id);
            head = null;
        }

        void post(int tweetId) {
            Tweet t = new Tweet(tweetId);
            // 新创建的放在链表头
            t.next = head;
            head = t;
        }

        void follow(int id) {
            followeeIds.add(id);
        }

        void unfollow(int id) {
            followeeIds.remove(id);
        }
    }

    class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id) {
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }
}


