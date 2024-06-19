# Check if All A's Appears Before All B's

# Array

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```
class Solution {
    public boolean checkString(String s) {
        int aPos = Integer.MIN_VALUE,
            bPos = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'a'){
                aPos = Math.max(aPos, i);
            }else if(c == 'b'){
                bPos = Math.min(bPos, i);
            }
        }
        if(aPos == Integer.MIN_VALUE || bPos == Integer.MAX_VALUE){
            return true;
        }
        return aPos < bPos;
    }
}
```

# String

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```
class Solution {
    public boolean checkString(String s) {
        return !s.contains("ba");
    }
}
```

# Array

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```
class Solution {
    public boolean checkString(String s) {
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i-1) == 'b' && s.charAt(i) == 'a'){
                return false;
            }
        }
        return true;
    }
}
```
