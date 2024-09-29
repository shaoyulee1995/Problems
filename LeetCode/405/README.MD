# Convert a Number to Hexadecimal

- Time Complexity: O(log4(N))
- Space Complexity: O(log4(N))
  - N as length of num

```java
class Solution{
    char[] map = {'0','1', '2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public String toHex(int num) {
        if(num == 0){
            return "0";
        }
        String res =  "";
        while(num != 0){
            res = map[(num&15)]+res;
            num = (num >>> 4);
        }
        return res;
    }

}
```
