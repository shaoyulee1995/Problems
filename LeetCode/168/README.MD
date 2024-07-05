# Excel Sheet Column Title

- Time Complexity: O(log<sub>26</sub>N)
- Space Complexity: O(1)
  - N as columnNumber

```
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber != 0){
            columnNumber--;
            sb.append((char)('A' + columnNumber%26));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
```
