# String
* Time Complexity: O((H-N)N)
* Space Complexity: O(N)
	* H as length of haystack
	* N as length of needle
```
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 || needle.length() == 0){
            return 0;
        }
        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            if(needle.equals(haystack.substring(i, i+needle.length()))){
                return i;
            }
        }
        return -1;
    }
}
```