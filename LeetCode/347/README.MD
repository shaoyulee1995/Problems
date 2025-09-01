# Top K Frequent Elements

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int num: nums){
            map.merge(num, 1, Integer::sum);
        }
        List<Integer>[] buckets = new List[nums.length+1];
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList();
            }
            buckets[freq].add(key);
        }
        int[] res = new int[k];
        int idx = 0;
        for(int i = buckets.length - 1; i >= 0 && idx < k; i--){
            if(buckets[i] == null){
                continue;
            }
            for(int j = 0; j < buckets[i].size() && idx < k; idx++, j++){
                res[idx] = buckets[i].get(j);
            }
        }
        return res;
    }
}
```
