# Basic Calculator

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```
class Solution {
    int i = 0;
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        char operator = '+';
        int num = 0;
        while(i < s.length()){
            char c = s.charAt(i++);
            if(c >= '0' && c <= '9'){
                num = num*10 + (c-'0');
            }
            if(c == '('){
                num = calculate(s);
            }
            if(i == s.length() || c == '+' || c == '-' || c == ')'){
                if(operator == '+'){
                    stack.push(num);
                }else{
                    stack.push(-num);
                }
                operator = c;
                num = 0;
            }
            if(c == ')'){
                break;
            }
        }
        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}
```
