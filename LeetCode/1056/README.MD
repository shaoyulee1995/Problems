# Confusing Number

- Time Complexity: O(log<sub>10</sub>N)
- Space Complexity: O(N)
  - N as n

```java
class Solution {
    public boolean confusingNumber(int n) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        int res = 0,
            temp = n;
        while(temp != 0){
            int bit = temp%10;
            if(!map.containsKey(bit)){
                return false;
            }
            res = res*10 + map.get(bit);
            temp /= 10;
        }
        return res != n;
    }
}
```
