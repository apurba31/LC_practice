package com.dsa.practice.heap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter {
/**
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow other users, and get the 10 most recent tweets in their news feed.
 * For implementation, we can use:
 * 1. A HashMap to store user data, including their tweets and the users they follow.
 * 2. A Tweet class to represent each tweet with a timestamp.
 * 3. A PriorityQueue (min-heap) to efficiently retrieve the 10 most recent tweets for the news feed.
 * The main operations to implement are:
 * - postTweet(userId, tweetId): User posts a new tweet.
 * - getNewsFeed(userId): Retrieve the 10 most recent tweet IDs in the user's
 * news feed.
 * - follow(followerId, followeeId): Follower follows a followee.
 * - unfollow(followerId, followeeId): Follower unfollows a followee.
 * Time Complexity:
 * - postTweet: O(1)
 * - getNewsFeed: O(N log 10) where N is the number of users
 * - follow: O(1)
 * - unfollow: O(1)
 */
private static int timestamp = 0;

//User class to store user information
private class User {
    int id;
    Set<Integer> followed;
    Tweet tweetHead;

    public User(int id) {
        this.id = id;
        followed = new HashSet<>();
        follow(id); // User follows themselves
        tweetHead = null;
    }

    public void follow(int id) {
        followed.add(id);
    }

    public void unfollow(int id) {
        if ( id != this.id ) {
            followed.remove(id);
        }
    }

    public void post(int id) {
        Tweet newTweet = new Tweet(id);
        newTweet.next = tweetHead;
        tweetHead = newTweet;
    }
}

//Tweet class to store tweet information
private class Tweet {
    int id;
    int time;
    Tweet next;

    public Tweet(int id) {
        this.id = id;
        time = timestamp++;
        next = null;
    }
}

private Map<Integer, User> userMap;

//Constructor
public DesignTwitter() {
    userMap = new HashMap<>();
}

//Compose a new tweet
public void postTweet(int userid, int tweetId) {
    if (!userMap.containsKey(userid)) {
        User newUser = new User(userid);
        userMap.put(userid, newUser);
    }
    userMap.get(userid).post(tweetId);
}

/**
 * Retrieve the 10 most recent tweet IDs in the user's news feed.
 * Each item in the news feed must be posted by users who the user followed or by the
 */
public List<Integer> getNewsFeed(int userId) {
    List<Integer> newsFeed = new LinkedList<>();
    if (!userMap.containsKey(userId)) {
        return newsFeed;
    }

    Set<Integer> followedUsers = userMap.get(userId).followed;
    PriorityQueue<Tweet> tweetHeap  = new PriorityQueue<>(followedUsers.size(), 
                (a, b) -> b.time - a.time);

    for ( int user : followedUsers ) {
        Tweet tweet = userMap.get(user).tweetHead;
        if ( tweet != null ) {
            tweetHeap.add(tweet);
        }
    }

    int count = 0;
    while(!tweetHeap.isEmpty() && count < 10) {
        Tweet tweet = tweetHeap.poll();
        newsFeed.add(tweet.id);
        count++;
        if ( tweet.next != null ) {
            tweetHeap.add(tweet.next);
        }
    }
    return newsFeed;
}

//Follower follows a followee
public void follow(int followerId, int followeeId) {
    if (!userMap.containsKey(followerId)) {
        User newUser = new User(followerId);
        userMap.put(followerId, newUser);
    }
    if(!userMap.containsKey(followeeId)) {
        User newUser = new User(followeeId);
        userMap.put(followeeId, newUser);
    }
    userMap.get(followerId).follow(followeeId);
}

//Follower unfollows a followee
public void unfollow( int followerId, int followeeId) {
    if (userMap.containsKey(followerId)) {
        userMap.get(followerId).unfollow(followeeId);
    }
}
public static void main(String[] args) {
    DesignTwitter twitter = new DesignTwitter();

    // User 1 posts a tweet (id = 5).
    twitter.postTweet(1, 5);

    // User 1's news feed should return a list with 1 tweet id -> [5].
    System.out.println(twitter.getNewsFeed(1)); // returns [5]

    // User 1 follows user 2.
    twitter.follow(1, 2);

    // User 2 posts a tweet (id = 6).
    twitter.postTweet(2, 6);

    // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
    // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
    System.out.println(twitter.getNewsFeed(1)); // returns [6, 5]

    // User 1 unfollows user 2.
    twitter.unfollow(1, 2);

    // User 1's news feed should return a list with 1 tweet id -> [5],
    // since user 1 is no longer following user 2.
    System.out.println(twitter.getNewsFeed(1)); // returns [5]
}
}