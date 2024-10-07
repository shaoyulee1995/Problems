# Number of Steps to Reduce a Number in Binary Representation to One

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public int numSteps(String s) {
        int res = 0, carry = 0;
        for(int i = s.length() - 1; i > 0; i--){
            if(s.charAt(i) -'0' + carry == 1){
                res += 2;
                carry = 1;
            }else{
                res += 1;
            }
        }
        return res + carry;
    }
}
```
