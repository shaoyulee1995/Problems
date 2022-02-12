# 3 Pointers
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public void sortColors(int[] nums) {
        int red = 0,
            white = 0,
            blue = nums.length-1;
       while(white <= blue){
           if(nums[white] == 0){
               swap(nums, white, red);
               white++;
               red++;
           }else if(nums[white] == 1){
               white++;
           }else if(nums[white] == 2){
               swap(nums, white, blue);
               blue--;
           }
       } 
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```