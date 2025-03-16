# Minimum Cuts to Divide a Circle 

- Time Complexity: O(1)
- Space Complexity: O(1)

```java
class Solution {
    public int numberOfCuts(int n) {
        if(n == 1){
            return 0;
        }
        return n%2 > 0? n: n/2;
    }
}
```