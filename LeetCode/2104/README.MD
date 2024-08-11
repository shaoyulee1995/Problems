# 2104. Sum of Subarray Ranges

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        for(int i = 0; i+1 < nums.length; i++){
            int min = nums[i],
                max = nums[i];
            for(int j = i+1; j < nums.length; j++){
                min = Math.min(nums[j], min);
                max = Math.max(nums[j], max);
                res += (max - min);
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {

    Stack<Integer> max, min;
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long res = 0;
        max = new Stack();
        min = new Stack();
        for(int i = 0; i <= n; i++){
            res += process(max, nums, i, (a, b) -> a < b) - process(min, nums, i, (a, b) -> a > b);
        }
        return res;
    }

    public long process (Stack<Integer> stack, int[] nums, int i, BiFunction<Integer, Integer, Boolean> compare){
        long res = 0;
        while(!stack.isEmpty() && (i == nums.length || compare.apply(nums[stack.peek()], nums[i]))){
            int pop_index = stack.pop(),
                prev_index = stack.isEmpty()? -1: stack.peek();
            res += 1l * nums[pop_index] * (pop_index - prev_index) * (i - pop_index);
        }
        stack.push(i);
        return res;
    }
}
```
