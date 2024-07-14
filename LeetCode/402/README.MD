# Remove K Digits

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of num

```java
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack();
        for(char c: num.toCharArray()){
            while(!stack.isEmpty() && k > 0 && c < stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while(k-- > 0){
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        for(char c: stack){
            if(c == '0' &&  sb.length() == 0){
                continue;
            }
            sb.append(c);
        }
        return sb.length() == 0? "0": sb.toString();
    }
}
```
