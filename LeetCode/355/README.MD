# Design Twitter

# HashMap

- Space Complexity: O(N)

```
public void postTweet(int userId, int tweetId)
```

- Time Complexity: O(1)

```
public List<Integer> getNewsFeed(int userId)
```

- Time Complexity: O(NlogN)

```
public void follow(int followerId, int followeeId)
```

- Time Complexity: O(1)

```
public void unfollow(int followerId, int followeeId)
```

- Time Complexity: O(1)

```
class Twitter {
    public static int timeStamp;
    public static HashMap<Integer, User> userMap;
    class Tweet{
        private int id, time;
        private Tweet next;
        public Tweet(int id, int time){
            this.id = id;
            this.time = time;
            next = null;
        }
        public int getId(){
            return this.id;
        }
    }
    class User{
        private Set<Integer> followed;
        private int id;
        private Tweet tweetHead;
        public User(int id){
            this.id = id;
            followed = new HashSet();
            followed.add(id);
            tweetHead = null;
        }
        public Tweet getTweetHead(){
            return tweetHead;
        }
        public Set<Integer> getFollowed(){
            return followed;
        }
        public void follow(int id){
            followed.add(id);
        }
        public void unfollow(int id){
            if(this.id != id)
                followed.remove(id);
        }
        public void post(int postId){
            Tweet newTweet = new Tweet(postId, timeStamp);
            timeStamp++;
            newTweet.next = tweetHead;
            tweetHead = newTweet;
        }
    }
    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap();
        timeStamp = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            User user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new LinkedList();
        if(!userMap.containsKey(userId)){
            return list;
        }
        Set<Integer> followedUser = userMap.get(userId).getFollowed();
        PriorityQueue<Tweet> pq = new PriorityQueue<>(followedUser.size(), (a, b)->(b.time - a.time));
        for(int user: followedUser){
            Tweet t = userMap.get(user).getTweetHead();
            if(t == null){
                continue;
            }
            pq.add(t);
        }
        while(!pq.isEmpty()){
            if(list.size() == 10){
                break;
            }
            Tweet t = pq.poll();
            list.add(t.getId());
            if(t.next != null){
                pq.add(t.next);
            }
        }
        return list;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User user = new User(followerId);
            userMap.put(followerId, user);
        }
        if(!userMap.containsKey(followeeId)){
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }
        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(userMap.containsKey(followerId)){
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}
```

```
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
```
