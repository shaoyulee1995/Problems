# Number of Beautiful Pairs

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(1)
  - N as nums.length

```java
class Solution {
    public int countBeautifulPairs(int[] nums) {
        int res = 0;
        for(int i = 0; i+1 < nums.length; i++){
            int firstDigit = Integer.toString(nums[i]).charAt(0) - '0';
            for(int j = i+1; j < nums.length; j++){
                int lastDigit = nums[j] % 10;
                if(gcd(firstDigit, lastDigit) == 1){
                    res++;
                }
            }
        }
        return res;
    }

    public int gcd(int x, int y){
        return (y == 0)? x: gcd(y, x%y);
    }
}
```
