# Add Binary

- Time Complexity: O(Max(A, B))
- Space Complexity: O(Max(A, B))
  - A as length of a
  - B as length of b

```java
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1,
            j = b.length()-1,
            carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0){
            int x = (i >= 0)? a.charAt(i) - '0': 0,
                y = (j >= 0)? b.charAt(j) - '0': 0,
                sum = x + y + carry;
            carry = sum/2;
            sb.insert(0, sum%2);
            i--;
            j--;
        }
        if(carry > 0){
            sb.insert(0, 1);
        }

        return sb.toString();
    }
}
```