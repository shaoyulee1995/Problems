# Happy Number

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as n

```java
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet();
        while(n != 1){
            n = parseSquare(n);
            if(!set.add(n)){
                return false;
            }
        }
        return true;
    }

    public int parseSquare(int n){
        int res = 0;
        while(n != 0){
            res += Math.pow(n%10, 2);
            n /= 10;
        }
        return res;
    }
}
```
