# Sliding Windows
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - `atMost`(nums, k-1);
    }

    public int atMost(int[] nums, int k){
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0, j = 0; j < nums.length; j++){
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while(map.size() > k){
                int freq = map.get(nums[i]);
                if(freq == 1){
                    map.remove(nums[i]);
                }else{
                    map.put(nums[i], freq-1);
                }
                i++;
            }
            res += j-i+1;
        }
        return res;
    }
}
```