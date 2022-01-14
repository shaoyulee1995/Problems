# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public int partitionDisjoint(int[] nums) {
        int[] L = new int[nums.length],
              R = new int[nums.length];
        int m = nums[0];
        for(int i = 0; i < L.length; i++){
            m = Math.max(nums[i], m);
            L[i] = m;
        }
        m = nums[nums.length-1];
        for(int i = nums.length - 1; i >= 0; i--){
            m = Math.min(m, nums[i]);
            R[i] = m;
        }
        
        for(int i = 1; i < nums.length; i++){
            if(L[i-1] <= R[i]){
                return i;
            }
        }
        return 0;
    }
}
```