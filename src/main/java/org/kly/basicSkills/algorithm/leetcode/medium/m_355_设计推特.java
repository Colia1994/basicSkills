package org.kly.basicSkills.algorithm.leetcode.medium;

import java.util.*;

/**
 * @Author Colia
 * @Date 2020/4/13.
 */
public class m_355_设计推特 {

    /**
     * 全局使用的时间戳字段，用户每发布一条推文之前 + 1
     */
    private static int timestamp = 0;


    class TweetNode {
        int tweetId;
        int timeStamp;
        TweetNode next;

        TweetNode(int tweetId, int timeStamp) {
            this.timeStamp = timeStamp;
            this.tweetId = tweetId;
        }
    }


    //Tweet是有序链表,按照时间戳来排序
    private Map<Integer, TweetNode> userTweetMap = new HashMap<>();

    //followMap
    private Map<Integer, Set<Integer>> userFollowMap = new HashMap<>();


    /**
     * Initialize your data structure here.
     */
    public m_355_设计推特() {


    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        TweetNode oldHead = userTweetMap.get(userId);
        userTweetMap.compute(userId, (k, v) -> new TweetNode(tweetId, ++timestamp)).next = oldHead;


    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<TweetNode> pq = new PriorityQueue<>((t1, t2) -> t2.timeStamp - t1.timeStamp);
        List<Integer> feed = new ArrayList<>();
        follow(userId, userId);
        userFollowMap.get(userId).forEach(followerId -> Optional.ofNullable(userTweetMap.get(followerId)).ifPresent(pq::offer));
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            TweetNode tw = pq.poll();
            feed.add(tw.tweetId);
            if (tw.next != null) {
                pq.offer(tw.next);
            }
            count++;
        }
        return feed;


    }


    public void follow(int followerId, int followeeId) {
        userFollowMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Optional.ofNullable(userFollowMap.get(followerId)).ifPresent(set -> set.remove(followeeId));
    }

}
