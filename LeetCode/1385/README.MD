# Find the Distance Value Between Two Arrays

- Time Complexity: O(NM)
- Space Complexity: O(1)
  - N as length of arr1
  - M as length of arr2

```java
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        for(int a: arr1){
            res++;
            for(int b: arr2){
                if(Math.abs(a-b) <= d){
                    res--;
                    break;
                }
            }
        }
        return res;
    }
}
```
