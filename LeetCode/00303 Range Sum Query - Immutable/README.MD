# Array
## Solution 1
* Space Complexity: O(N)
sumRange
	* Time Complexity: O(1)
```
class NumArray {
    int[] preSum;
    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        for(int i = 1; i < preSum.length; i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
    }
    public int sumRange(int left, int right) {
        System.out.println(preSum[right+1]+ " " + preSum[left]);
        return preSum[right+1] - preSum[left];
    }
}
```
## Solution 2
* Space Complexity: O(N)
sumRange
	* Time Complexity: O(N)
```
class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }   
    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i = left; i <= right; i++){
            sum += nums[i];
        }
        return sum;
    }
}
```

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
```