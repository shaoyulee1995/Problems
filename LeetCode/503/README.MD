# Next Greater Element II

# Monotonic Stack

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack();
        for(int i = 2*n-1; i >= 0; i--){
            while(!stack.isEmpty() && nums[i%n] >= stack.peek()){
                stack.pop();
            }
            res[i%n] = (stack.isEmpty())? -1: stack.peek();
            stack.push(nums[i%n]);
        }
        return res;
    }
}
```
