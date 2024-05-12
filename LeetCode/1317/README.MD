# Convert Integer to the Sum of Two No-Zero Integers
# Math
* Time Complexity: O(Nlog<sub>10</sub>N)
* Space Complexity: O(1)
	* N as n
```
class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i = 1; i <= n; i++){
          if(getNum(i) && getNum(n-i)){
            return new int[]{i, n-i};
          }
        }
        return null;
    }
    public boolean getNum(int num){
      while(num != 0){
        if(num%10 == 0){
          return false;
        }
        num /= 10;
      }
      return true;
    }
}
```