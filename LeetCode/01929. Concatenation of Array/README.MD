# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length*2];
        for(int i = 0, j = nums.length; i < nums.length; i++, j++){
            res[i] = nums[i];
            res[j] = nums[i];
        }
        return res;
    }
}
```