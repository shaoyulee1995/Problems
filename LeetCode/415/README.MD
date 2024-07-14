# Add Strings

- Time Complexity: O(Max(N,M))
- Space Complexity: O(Max(N,M))
  - N as length of num1
  - M as length of num2

```java
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1,
            j = num2.length()-1,
            carry = 0;
        while(i >= 0 || j >= 0){
            int a = (i>=0)? num1.charAt(i)-'0': 0,
                b = (j>=0)? num2.charAt(j)-'0': 0,
                sum = a+b+carry;
            carry = sum/10;
            sb.append(sum%10);
            i--;
            j--;
        }
        if(carry > 0){
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
```
