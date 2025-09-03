# K-diff Pairs in an Array

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int num: nums){
            map.merge(num, 1, Integer::sum);
        }
        int res = 0;
        for(int key: map.keySet()){
            if(k == 0 && map.get(key) >= 2){
                res++;
            }else if(k > 0 && map.containsKey(key + k)){
                res++;
            }
        }
        return res;
    }
}
```