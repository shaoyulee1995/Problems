# Missing Number
# Space Requires
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int missingNumber(int[] nums) {
        int[] res = new int[nums.length+1];
        for(int num: nums){
            res[num]++;
        } 
        for(int i = 0; i < res.length; i++){
            if(res[i] == 0){
                return i;
            }
        }
        return -1;
    }
}
```

# Sort 
* Time Complexity: O(NlogN)
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums[0] != 0){
            return 0;
        }
        int diff = nums[0] - 0;
        for(int i = 0; i < nums.length; i++){
            if(diff != nums[i] - i){
                return i;
            }
        }
        return nums.length;
    }
}
```