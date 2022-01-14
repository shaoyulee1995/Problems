# Sliding Windows
* Time Complexity: O(N)
* Space Complexity: O(1)
## Java
```
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, res = 0;
        HashSet<Character> set = new HashSet();
        while(right < s.length()){
            char c = s.charAt(right);
            if(!set.contains(c)){
                set.add(c);
                right++;
                res = Math.max(res, set.size());
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return res;
    }
}
```