# Bit
* Time Complexity: O(32)
* Space Complexity: O(1)
	* N as length of abbr
```
class Solution {
    public boolean reorderedPowerOf2(int n) {
        long target = counter(n);
        for(int i = 0; i < 32; i++){
            if(counter(1 << i) == target){
                return true;
            }
        }
        return false;
    }
    
    public long counter(int n){
        int res = 0;
        for(; n > 0; n/=10){
            res += (int)Math.pow(10, n%10);
        }
        return res;
    }
}
```