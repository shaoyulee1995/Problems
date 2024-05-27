# Multiply Strings

- Time Complexity: O(NM)
- Space Complexity: O(Max(M,N))
  - N as length of num1
    - M as length of num2

```java
class Solution {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length()+num2.length()];
        int carry = 0;
        for(int i = num1.length()-1; i >= 0; i--){
            for(int j = num2.length()-1; j >= 0; j--){
                int a = num1.charAt(i)-'0',
                    b = num2.charAt(j)-'0',
                    product = a*b,
                    sum = product + res[i+j+1];
                res[i+j+1] = sum%10;
                res[i+j] += sum/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int d: res){
            if(!(sb.length()==0 && d == 0)){
                sb.append(d);
            }
        }
        return sb.length() == 0? "0": sb.toString();
    }
}
```
