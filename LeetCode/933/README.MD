# Number of Recent Calls

# Queue

- Time Complexity: O(P)
- Space Complexity: O(3000)

```
class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList();
    }
    public int ping(int t) {
        queue.add(t);
        while(queue.peek() < t-3000){
            queue.poll();
        }
        return queue.size();
    }
}
```

```
/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
```
