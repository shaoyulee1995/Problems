# Split a String in Balanced Strings

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int balancedStringSplit(String s) {
        int cnt = 0, res =0;
        for(char c: s.toCharArray()){
            if(c == 'R'){
                cnt++;
            }else if(c == 'L'){
                cnt--;
            }
            if(cnt == 0){
                res++;
            }
        }
        return res;
    }
}
```
