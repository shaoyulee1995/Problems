# Count Equal and Divisible Pairs in an Array

- Time Complexity: O(Vv<sup>2</sup>)
- Space Complexity: O(N)
  - N as length of nums
  - V as number of values in map
  - v as max length of list in Vs

```java
class Solution {
    public int countPairs(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            map.computeIfAbsent(nums[i], x -> new ArrayList()).add(i);
        }
        int res = 0;
        for(List<Integer> value: map.values()){ 
            if(value.size() < 2){
                continue;
            }
            for(int i = 0; i < value.size(); i++){ 
                for(int j = 0; j < i; j++){ 
                    if((value.get(i) * value.get(j)) % k == 0){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
```