# Set1 Sliding Windows
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
# Set2 Sliding Windows
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet();
        for(int i = 0, j = 0; j < s.length(); j++){
            while(!set.add(s.charAt(j))){
                set.remove(s.charAt(i++));
            }
            res = Math.max(res, set.size());
        }
        return res;
    }
}
```