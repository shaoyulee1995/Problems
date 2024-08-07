# Last Stone Weight

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of stones

```java
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stone: stones){
            pq.add(-stone);
        }
        while(pq.size() > 1){
            int stone1 = -pq.remove(),
                stone2 = -pq.remove();
            if(stone1 != stone2){
                pq.add(-(stone1 - stone2));
            }
        }
        return pq.isEmpty()? 0: -pq.remove();
    }
}
```
