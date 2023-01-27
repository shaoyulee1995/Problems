# Sliding Windows
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
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
# Cleaner Sliding Windows
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        int i = 0,
            res = 0;
        for(int j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            while(!set.add(c)){
                set.remove(s.charAt(i++));
            }
            res = Math.max(res, j-i+1);
        }
        return res;
    }
}
```