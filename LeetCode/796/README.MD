# Rotate String
# String
* Time Complexity: O(M*N)
	* N and M are the length of the search string and pattern respectively.
* Space Complexity: O(S)
```
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        StringBuilder sb = new StringBuilder(s + s);
        return sb.toString().indexOf(goal) != -1;       
    }
}
```