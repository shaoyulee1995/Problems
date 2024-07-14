# Sum of Digits of String After Convert

- Time Complexity: O(SK)
- Space Complexity: O(S)
  - K as k
    - S as length of s

```java
class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            sb.append(c-'a'+1);
        }
        if(sb.toString().length() == 1){
            return Character.getNumericValue(sb.toString().charAt(0));
        }
        String val = sb.toString();
        int sum = 0;
        while(k-- > 0 && val.length() > 1){
            sum = 0;
            for(char c: val.toCharArray()){
                sum += Character.getNumericValue(c);
            }
            val = String.valueOf(sum);
        }
        return sum;
    }
}
```
