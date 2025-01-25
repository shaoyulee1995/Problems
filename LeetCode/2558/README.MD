# Take Gifts From the Richest Pile

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of gifts

```java
class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int g: gifts){
            pq.offer(g);
        }
        for(int i = 0; i < k; i++){
            int x = pq.poll();
            pq.offer((int)Math.sqrt(x));
        }
        long res = 0;
        while(!pq.isEmpty()){
            res += pq.poll();
        }
        return res;
    }
}
```