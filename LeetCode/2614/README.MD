# Prime In Diagonal

# Matrix

- Time Complexity: O(NM)
- Space Complexity: O(NM)
  - N as length of nums
  - M as length of nums[0]

```
class Solution {
    public int diagonalPrime(int[][] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[0].length; j++){
                if(i == j || i+j == nums.length-1){
                    if(isPrime(nums[i][j])){
                        res = Math.max(res, nums[i][j]);
                    }
                }
            }
        }
        return res;
    }

    public boolean isPrime(int num){
        if(num < 2){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}
```
