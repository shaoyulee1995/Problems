# Finding the Users Active Minutes

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of logs

```java
class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap();
        for(int[] log: logs){
            map.putIfAbsent(log[0], new HashSet());
            map.get(log[0]).add(log[1]);
        }
        int[] res = new int[k];
        for(int num: map.keySet()){
            res[map.get(num).size() - 1]++;
        }
        return res;
    }
}
```
