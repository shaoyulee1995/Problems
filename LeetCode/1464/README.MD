# Maximum Product of Two Elements in an Array

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE,
            max2 = max1;
        for(int num: nums){
            if(max1 < num){
                max2 = max1;
                max1 = num;
            }else if(max2 < num){
                max2 = num;
            }
        }
        return (max1-1)*(max2-1);
    }
}
```
