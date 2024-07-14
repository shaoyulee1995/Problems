# Merge Similar Items

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as length of Max(items1, items2)

```java
class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> map = new TreeMap();
        for(int[] item: items1){
            map.merge(item[0], item[1], Integer::sum);
        }
        for(int[] item: items2){
            map.merge(item[0], item[1], Integer::sum);
        }
        List<List<Integer>> res = new ArrayList();
        for(var e: map.entrySet()){
            res.add(Arrays.asList(e.getKey(), e.getValue()));
        }
        return res;
    }
}
```
