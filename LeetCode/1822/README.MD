# Sign of the Product of an Array

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public int arraySign(int[] nums) {
        int bal = 1;
        for(int num: nums){
            if(num == 0){
                return 0;
            }
            if(num < 0){
                bal *= -1;
            }
        }
        return bal;
    }
}
```
