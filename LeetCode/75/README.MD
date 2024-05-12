# Sort Colors
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
                swap(nums, red, white);
                red++; white++;
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
# Counting Array
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public void sortColors(int[] nums) {
        int sizeZeros = 0,
            sizeOnes = 0,
            sizeTwos = 0;  
        for(int num: nums){
            if(num == 0){
                sizeZeros++;
            }else if(num == 1){
                sizeOnes++;
            }else{
                sizeTwos++;
            }
        }
        for(int i = 0; i  < nums.length; i++){
            if(i < sizeZeros){
                nums[i] = 0;
            }else if(i < sizeZeros + sizeOnes){
                nums[i] = 1;
            }else{
                nums[i] = 2;
            }
        }
    }
}
```