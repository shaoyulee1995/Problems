# Array
* Time Complexity: O(NlogN)
* Space Complexity: O(1)
    * N as length of nums
```
class Solution {
    public boolean isConsecutive(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1] + 1){
                return false;
            }
        }
        return true;
    }
}
```
# Array
* Time Complexity: O(N)
* Space Complexity: O(1)
    * N as length of nums
```
class Solution {
    public boolean isConsecutive(int[] nums) {
        int min = IntStream.of(nums).min().getAsInt();
        int max = min+nums.length-1;
        int[] cnt = new int[max+1];
        for(int num: nums){
            if(num > max){
                return false;
            }
            cnt[num]++;
        }
        for(int i = min; i < cnt.length; i++){
            if(cnt[i] != 1){
                return false;
            }
        }
        return true;
    }
}
```