# Counting Array
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public int sumOfUnique(int[] nums) {
        int[] cnt = new int[101];
        for(int num: nums){
            cnt[num]++;
        }
        int res = 0;
        for(int i = 0; i < cnt.length; i++){
            if(cnt[i] == 1){
                res += i;
            }
        }
        return res;
    }
}
```