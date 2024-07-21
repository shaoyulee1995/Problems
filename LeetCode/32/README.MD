# Longest Valid Parentheses

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else if(c ==')'){
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    res = Math.max(res, i-stack.peek());
                }
            }
        }
        return res;
    }
}
```
