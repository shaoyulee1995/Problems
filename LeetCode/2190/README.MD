# Most Frequent Number Following Key In an Array
# HashMap
* Time Complexity: O(NW)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap();
        int res = Integer.MIN_VALUE;
        for(int i = 0, max = 0; i+1 < nums.length; i++){
            if(nums[i] == key){
                int candidate = nums[i+1];
                map.put(candidate, map.getOrDefault(candidate, 0) + 1);
                if(max < map.get(candidate)){
                    max = map.get(candidate);
                    res = candidate;
                }
            }
        }
        return res;
    }
}

```