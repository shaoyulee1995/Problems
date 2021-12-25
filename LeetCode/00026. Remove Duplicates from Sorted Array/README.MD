# Solution 1
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;
        
        int curIndex = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[curIndex] == nums[i]){
                continue;
            }else{
                nums[++curIndex] = nums[i];
            }
        }
        return curIndex + 1;
    }
}
```

# Solution 2
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int fast = 0, 
            slow = 0;
        while(fast < nums.length){
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
```