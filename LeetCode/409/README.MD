# Longest Palindrome
# Set
* Time Complexity: O(S)
* Space Complexity: O(S)
	* S as length of s
```
class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet();
        int pairs = 0;
        for(char c: s.toCharArray()){
            if(set.contains(c)){
                set.remove(c);
                pairs++;
            }else{
                set.add(c);
            }
        }
        return (set.isEmpty())? pairs*2: pairs*2+1;
    }
}
```
# Set
* Time Complexity: O(S)
* Space Complexity: O(S)
	* S as length of s
```
class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet();
        int res = 0;
        for(char c: s.toCharArray()){
            if(!set.add(c)){
                set.remove(c);
                res++;
            }
        }
        return set.isEmpty()? res*2: res*2 + 1;
    }
}
```