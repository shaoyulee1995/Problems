# Number of Segments in a String

# Array

- Time Complexity: O(N)
- Space Complexity: O(1)

```
class Solution {
    public int countSegments(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' ' && (i == 0 ||s.charAt(i-1) == ' ')){
                ans++;
            }
        }
        return ans;
    }
}
```
