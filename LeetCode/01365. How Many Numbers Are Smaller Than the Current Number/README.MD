# BF
* Time Complexity: O(N<sup>2</sup>)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i != j){
                    res[i] += (nums[i] > nums[j])?1:0;
                }
            }
        }
        return res;
    }
}
```
# Counting
* Time Complexity: O(N)
* Space Complexity: O(102)
	* N as length of nums
```
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[102];
        for(int i = 0; i < nums.length; i++){
            cnt[nums[i]+1]++;
        }
        for(int i = 1; i < cnt.length; i++){
            cnt[i] = cnt[i] + cnt[i-1];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] =cnt[nums[i]];
        }
        return nums;
    }
}
```