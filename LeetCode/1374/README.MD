# Generate a String With Characters That Have Odd Counts

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as n

```java
class Solution {
    public String generateTheString(int n) {
        char[] res = new char[n];
        Arrays.fill(res, 'a');
        if(n%2 == 0){
            res[0] = 'b';
        }
        return new String(res);
    }
}
```
