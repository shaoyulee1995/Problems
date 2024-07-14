# Minimum Deletions to Make String Balanced

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public int minimumDeletions(String s) {
        Deque<Character> stack = new ArrayDeque();
        int res = 0;
        for(char c: s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == 'b' && c == 'a'){
                stack.pop();
                res++;
            }else{
                stack.push(c);
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public int minimumDeletions(String s) {
        int b_count = 0,
            dp = 0;
        for(char c: s.toCharArray()){
            if(c == 'b'){
                b_count++;
            }else{
                dp = Math.min(dp+1, b_count);
            }
        }
        return dp;
    }
}
```
