# Final Value of Variable After Performing Operations

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of operations

```java
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for(String op: operations){
            res += (op.charAt(1) == '+')? 1: -1;
        }
        return res;
    }
}
```
