# Sliding Windows
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet();
        int i = 0,
            j = 0,
            res = 0,
            n = s.length();
        while(j < n){
            char c = s.charAt(j);
            if(!set.contains(c)){
                set.add(c);
                j++;
                res = Math.max(res, set.size());
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }
}
```