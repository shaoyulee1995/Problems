# HashMap
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as len of nums
```
class Solution {
    public int countKDifference(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            res += map.getOrDefault(nums[i]-k, 0) + 
                   map.getOrDefault(nums[i]+k, 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return res;
    }
}
```
# BF
* Time Complexity: O(N<sup>2</sup>)
* Space Complexity: O(1)
	* N as len of nums
```
class Solution {
    public int countKDifference(int[] nums, int k) {
        int res = 0;
        for(int i = 0; i+1 < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(Math.abs(nums[i]-nums[j]) == k){
                    res++;
                }
            }
        }
        return res;
    }
}
```