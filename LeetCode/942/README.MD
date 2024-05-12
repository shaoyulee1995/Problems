# DI String Match
# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public int[] diStringMatch(String s) {
        int[] res = new int[s.length() + 1];
        int low = 0, high = s.length();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'I'){
                res[i] = low++;
            }else if(c == 'D'){
                res[i] = high--;
            }
        }
        res[s.length()] = low;
        return res;
    }
}
```