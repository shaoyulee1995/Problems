# Sliding Windows
* Time Complexity: O(N)
* Space Complexity: O(1)
## Java
```
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet();
        int l = 0, r = 0, res = 0;
        while(r < s.length()){
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                res = Math.max(res, set.size());
                r++;
            }else{
                set.remove(s.charAt(l));
                l++;
            }
        }
        return res;
    }
}
```