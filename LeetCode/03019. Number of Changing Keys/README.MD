# String
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of s
```
class Solution {
    public int countKeyChanges(String s) {
        int res = 0;
        for(int i = 1; i < s.length(); i++){
            if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(i-1))){
                continue;
            }
            res++;
        }
        return res;
    }
}
```