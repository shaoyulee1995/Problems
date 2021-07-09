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