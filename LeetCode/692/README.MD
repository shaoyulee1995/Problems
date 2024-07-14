# Top K Frequent Words

# PriorityQueue, HashMap

- Time Complexity: O(NlogK)
- Space Complexity: O(N)
  - N as length of words
  - K as k

```java
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap();
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> (a.getValue() == b.getValue())? b.getKey().compareTo(a.getKey()): a.getValue() - b.getValue());

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            pq.add(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }
        LinkedList<String> res = new LinkedList();
        while(!pq.isEmpty()){
            res.add(0, pq.poll().getKey());
        }
        return res;
    }
}
```
