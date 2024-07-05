# Add Binary

- Time Complexity: O(A)
- Space Complexity: O(A)
  - A as length of a

```java
class Solution {
    public String addBinary(String a, String b) {
        if(a.length() < b.length()){
            return addBinary(b, a);
        }
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1,
            j = b.length() - 1,
            carry = 0;
        while(i >= 0 && j >= 0){
            int x = (a.charAt(i) == '0')? 0: 1;
            int y = (b.charAt(j) == '0')? 0: 1;
            int sum = x + y + carry;
            carry = sum / 2;
            sb.insert(0, sum%2);
            i--;
            j--;
        }
        while(i >= 0){
            int x = (a.charAt(i) == '0')? 0: 1;
            int sum = x + carry;
            carry = sum / 2;
            sb.insert(0, sum % 2);
            i--;
        }
        if(carry > 0){
            sb.insert(0, "1");
        }
        return sb.toString();
    }
}
```
