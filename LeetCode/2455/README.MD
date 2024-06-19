# Average Value of Even Numbers That Are Divisible by Three

# Array

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums

```
class Solution {
    public int averageValue(int[] nums) {
        int sum = 0,
            size = 0;
        for(int num: nums){
            if(num%3 == 0 && num%2 == 0){
                sum += num;
                size++;
            }
        }
        if(size == 0){
            return 0;
        }
        return (int)sum/size;
    }
}
```
