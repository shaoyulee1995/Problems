# Find the Pivot Integer

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as n
```java
class Solution {
    public int pivotInteger(int n) {
        int totalSum = n*(n+1)/2;
        for(int i = 1, leftSum = 0; i <= n; i++){
            leftSum += i;
            if(leftSum == totalSum - leftSum + i){
                return i;
            }else if(leftSum > totalSum - leftSum + i){
                return -1;
            }
        }
        return -1;
    }
}
```
