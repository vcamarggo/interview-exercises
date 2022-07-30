package com.interview.sde.algorithm.queue;

import java.util.*;

//https://leetcode.com/problems/design-twitter/
public class Twitter {
    private final Map<Integer, User> users;
    private final Deque<Tweet> newsFeed;

    static class Tweet {
        private final int tweetId;
        private final int userId;

        Tweet(int tweetId, int userId) {
            this.tweetId = tweetId;
            this.userId = userId;
        }
    }

    static class User {

        private final int MAX_FEED_SIZE = 10;

        private final Set<Integer> follows;

        User(int userId) {
            this.follows = new HashSet<>();
            follows.add(userId);
        }

        void addFollows(int followeeId) {
            follows.add(followeeId);
        }

        void removeFollows(int followeeId) {
            follows.remove(followeeId);
        }

        //TODO save the feed and the last timestamp for a news,
        //if the function is invoked again,
        //evicts the last elements in the list and add up to the last timestamp
        List<Integer> generatePersonalizedNewsFeed(Deque<Tweet> newsFeed) {
            List<Integer> personalizedNewsFeed = new ArrayList<>();
            for (Tweet t : newsFeed) {
                if (this.follows.contains(t.userId)) {
                    personalizedNewsFeed.add(t.tweetId);
                    if (personalizedNewsFeed.size() == MAX_FEED_SIZE) {
                        break;
                    }
                }
            }
            return personalizedNewsFeed;
        }

    }

    public Twitter() {
        this.users = new HashMap<>();
        this.newsFeed = new LinkedList<>();
    }

    public void postTweet(int userId, int tweetId) {
        this.newsFeed.offerFirst(new Tweet(tweetId, userId));
    }

    public List<Integer> getNewsFeed(int userId) {
        return users.computeIfAbsent(userId, k -> new User(userId)).generatePersonalizedNewsFeed(this.newsFeed);
    }

    public void follow(int followerId, int followeeId) {
        users.computeIfAbsent(followerId, k -> new User(followerId)).addFollows(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        users.computeIfAbsent(followerId, k -> new User(followerId)).removeFollows(followeeId);
    }
}
