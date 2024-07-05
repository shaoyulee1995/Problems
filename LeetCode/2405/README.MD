# Optimal Partition of String

- Time Complexity: O(N)
- Space Complexity: O(26)
  - N as length of s

```
class Solution {
    public int partitionString(String s) {
        int[] seen = new int[26];
        Arrays.fill(seen, -1);
        int idx = 0,
            count = 1;
        for(int i = 0; i < s.length(); i++){
            if(seen[s.charAt(i)-'a'] >= idx){
                idx = i;
                count++;
            }
            seen[s.charAt(i)-'a'] = i;
        }
        return count;
    }
}
```
