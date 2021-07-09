* Time Complexity: O(log(N))
* Space Complexity: O(log(N))

```
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || x >= Integer.MAX_VALUE){
            return false;
        }
        int original = x, reverse = 0;
        while(x != 0){
            reverse = reverse*10 + x % 10;
            x /= 10;
        }
        return reverse == original;
    }
}
```