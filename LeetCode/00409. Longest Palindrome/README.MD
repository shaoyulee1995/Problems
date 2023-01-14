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