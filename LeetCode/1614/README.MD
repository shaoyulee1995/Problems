# Maximum Nesting Depth of the Parentheses

- Time Complexity: O(N)
- Space Complexity: O(1)

```java
class Solution {
    public int maxDepth(String s) {
        int cnt = 0, max = Integer.MIN_VALUE;
        for(char c: s.toCharArray()){
            if(c == '('){
                cnt++;

            }else if(c == ')'){
                cnt--;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
```
