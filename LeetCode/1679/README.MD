# Max Number of K-Sum Pairs

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        int res = 0;
        for(int num: nums){
            int complement = k-num;
            if(map.containsKey(complement)){
                res++;
                if(map.get(complement) == 1){
                    map.remove(complement);
                }else{
                    map.put(complement, map.get(complement)-1);
                }
            }else{
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return res;
    }
}
```
