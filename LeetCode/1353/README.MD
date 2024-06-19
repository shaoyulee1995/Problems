# Maximum Number of Events That Can Be Attended

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of events

```java
class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        for(int d = 1, i = 0; d <= 1e5; d++){
            while(!pq.isEmpty() && pq.peek() < d){
                pq.poll();
            }
            while(i < events.length && events[i][0] == d){
                pq.add(events[i++][1]);
            }
            if(!pq.isEmpty()){
                res++;
                pq.poll();
            }
        }
        return res;
    }
}
```
