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