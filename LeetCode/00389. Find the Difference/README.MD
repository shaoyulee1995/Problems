# String
* Time Complexity: O(T)
* Space Complexity: O(26)
	* T as length of t
```
class Solution {
    public char findTheDifference(String s, String t) {
        int[] cntS = new int[26],
              cntT = new int[26];
        for(char c: s.toCharArray()){
            cntS[c-'a']++;
        }
        for(char c: t.toCharArray()){
            cntT[c-'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(cntS[i] != cntT[i]){
                return (char)(i+'a');
            }
        }
        return ' ';
    }
}
```
# Bit
* Time Complexity: O(T)
* Space Complexity: O(1)
	* T as length of t
```
class Solution {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for(char c: s.toCharArray()){
            res ^= c;
        }
        for(char c: t.toCharArray()){
            res ^= c;
        }
        return res;
    }
}
```