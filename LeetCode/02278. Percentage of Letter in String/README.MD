# String
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of s
```
class Solution {
    public int percentageLetter(String s, char letter) {
        int cnt = 0;
        for(char c: s.toCharArray()){
            if(c == letter){
                cnt++;
            }
        }
        return (int)(100.0*cnt/s.length());
    }
}
```