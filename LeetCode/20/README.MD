# Valid Parentheses

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as characters in s

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else if(stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
```
