# Alternating Digit Sum

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of n

```java
class Solution {
    public int alternateDigitSum(int n) {
        Stack<Integer> stack = new Stack();
        while(n != 0){
            stack.push(n%10);
            n /= 10;
        }
        int res = 0;
        boolean isPositive = true;
        while(!stack.isEmpty()){
            res += ((isPositive)? 1: -1) * stack.pop();
            isPositive = !isPositive;
        }
        return res;
    }
}
```
