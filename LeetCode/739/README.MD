# Daily Temperatures

# Monotonic Stack

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of list

```
class Solution {
    public int[] dailyTemperatures(int[] list) {
        Stack<Integer> stack = new Stack();
        int[] res = new int[list.length];
        for(int i = list.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && list[i] >= list[stack.peek()]){
                stack.pop();
            }
            res[i] = (stack.isEmpty())? 0: stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
```
