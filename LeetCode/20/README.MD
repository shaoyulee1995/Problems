# Valid Parentheses

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as characters in s

```java
class Solution {
    public boolean isValid(String s) {
       ArrayDeque<Character> deque = new ArrayDeque();
       for(char c: s.toCharArray()){
           if(c == '('){
               deque.offerLast(')');
           }else if(c == '['){
               deque.offerLast(']');
           }else if(c == '{'){
               deque.offerLast('}');
           }else if(deque.isEmpty() || c != deque.pollLast()){
               return false;
           }
       }
       return deque.isEmpty();
    }
}
```
