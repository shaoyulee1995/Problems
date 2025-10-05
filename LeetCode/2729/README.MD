# Check if The Number is Fascinating

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of stringbuilder

```java
class Solution {
    public boolean isFascinating(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(n));
        sb.append(String.valueOf(2 * n));
        sb.append(String.valueOf(3 * n));
        int[] nums = new int[10];
        for (char c : sb.toString().toCharArray()) {
            nums[c - '0']++;
        }
        for (int i = 1; i < 10; i++) {
            if (nums[i] != 1) {
                return false;
            }
        }
        return true;
    }
}
```