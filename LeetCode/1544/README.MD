# Make The String Great

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()){
            if(!stack.isEmpty() && Math.abs(stack.peek()-c)==32){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c: stack){
            sb.append(c);
        }
        return sb.toString();
    }
}
```
