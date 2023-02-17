# 2 Pointers
## Solution 1
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as num
```
class Solution {
    public int removeElement(int[] nums, int val) {
        int cnt = 0;
        for(int num: nums){
            if(num != val){
                nums[cnt++]= num;
            }
        }
        return cnt;
    }
}
```
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as num
```
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0,
            j = 0;
        while(j < nums.length){
            if(nums[j] != val){
                nums[i++] = nums[j]; 
            }
            j++;
        }
        return i;
    }
}
```