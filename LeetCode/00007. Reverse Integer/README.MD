* Time Complexity: O(log(N))
* Space Complexity: O(1)

```
class Solution {
    public int reverse(int x) {
        long ans = 0; 
        while(x!=0){
            ans = ans*10 + x%10;
            x /=10;
        }
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE){
            return 0;
        }
        return (int)ans;
    }
}
```
* Time Complexity: O(log(N))
* Space Complexity: O(1)
```
class Solution {
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE){
            return 0;
        }
        int sign = (x < 0) ? -1: 1;
        int res = 0;
        x = Math.abs(x);
        while(x != 0){
            if(res * 10 < Integer.MIN_VALUE + x % 10|| res > Integer.MAX_VALUE/10){
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res * sign;
    }
}
```