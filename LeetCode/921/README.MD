# Minimum Add to Make Parentheses Valid

- Time Complexity: O(S)
- Space Complexity: O(S)
  - S as length of s

```java
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack();
        int res = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(stack.isEmpty() || c != stack.pop()){
                res++;
            }
        }
        return (stack.isEmpty())? res: stack.size() + res;
    }
}
```
