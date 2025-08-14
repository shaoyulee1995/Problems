# Basic Calculator II

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public int calculate(String s) {
        int res = 0,
            num = 0;
        char op = '+';
        Stack<Integer> stack = new Stack();
        for(char c: (s+"+").toCharArray()){
            if(c == ' '){
                continue;
            }
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }else{
                switch(op){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop()*num);
                        break;
                    case '/':
                        stack.push(stack.pop()/num);
                        break;
                }
                op = c;
                num = 0;
            }
        }
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public int calculate(String s) {
        int res = 0,
            num = 0,
            temp = 0;
        char op = '+';
        for(char c: (s+"+").toCharArray()){
            if(c == ' '){
                continue;
            }
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }else{
                switch(op){
                    case '+':
                        res += temp;
                        temp = num;
                        break;
                    case '-':
                        res += temp;
                        temp = -num;
                        break; 
                    case '*':
                        temp *= num;
                        break;
                    case '/':
                        temp /= num;
                        break;
                }
                op = c;
                num = 0;
            }
        }
        res += temp;
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {

    private int index = 0;
    private String s;

    public int calculate(String s) {
        this.s = s.replaceAll("\\s+", "");
        this.index = 0;
        return evaluateExpression();
    }

    private int evaluateExpression() {
        int result = evaluateTerm();

        while (index < s.length()) {
            char op = s.charAt(index);
            if (op != '+' && op != '-') break;
            index++;
            int nextTerm = evaluateTerm();
            if (op == '+') {
                result += nextTerm;
            } else {
                result -= nextTerm;
            }
        }
        return result;
    }

    private int evaluateTerm() {
        int result = evaluateNumber();

        while (index < s.length()) {
            char op = s.charAt(index);
            if (op != '*' && op != '/') break;
            index++;
            int nextNumber = evaluateNumber();
            if (op == '*') {
                result *= nextNumber;
            } else {
                result /= nextNumber;
            }
        }
        return result;
    }

    private int evaluateNumber() {
        int num = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            num = num * 10 + (s.charAt(index) - '0');
            index++;
        }
        return num;
    }
}
```