# Student Attendance Record I

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```
class Solution {
    public boolean checkRecord(String s) {
        int absent = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'A'){
                absent++;
            }
            if(absent == 2){
                return false;
            }
            if(c == 'L' && i != 0 && i != s.length() - 1){
                char prev = s.charAt(i-1),
                     next = s.charAt(i+1);
                if(prev == 'L' && next == 'L'){
                    return false;
                }
            }
        }
        return true;
    }
}
```
