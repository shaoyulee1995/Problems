# Reordered Power of 2

# Bit

- Time Complexity: O(32)
- Space Complexity: O(1)
  - N as length of abbr

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

# Array Counter

- Time Complexity: O(log<sup>2</sup>N)
- Space Complexity: O(logN)
  - N as length of abbr

```
class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] res = count(n);
        for(int i = 0; i < 32; i++){
            if(Arrays.equals(res, count(1 << i))){
                return true;
            }
        }
        return false;
    }
    public int[] count(int n){
        int[] res = new int[10];
        while(n > 0){
            res[n%10]++;
            n /= 10;
        }
        return res;
    }
}
```
