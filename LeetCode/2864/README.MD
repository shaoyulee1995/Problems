# Maximum Odd Binary Number

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as the length of s

```java
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0;
        for(char c: s.toCharArray()){
            if(c == '1'){
                ones++;
            }
        }
        char[] res = new char[s.length()];
        int idx = 0;
        while(ones > 1){
            res[idx++] = '1';
            ones--;
        }
        while(idx != s.length()-1){
            res[idx++] = '0';
        }
        res[res.length-1] = '1';
        return new String(res);
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as the length of s

```java
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0;
        for(char c: s.toCharArray()){
            if(c == '1'){
                ones++;
            }
        }
        char[] res = new char[s.length()];
        Arrays.fill(res, '0');
        int idx = 0;
        while(ones > 1){
            res[idx++] = '1';
            ones--;
        }
        res[res.length-1] = '1';
        return new String(res);
    }
}
```
