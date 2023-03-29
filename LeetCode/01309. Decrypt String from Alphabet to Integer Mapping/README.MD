# Forward
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i = 0; i < s.length(); i++){
            if(i + 2 < s.length() && s.charAt(i + 2) == '#'){
                index = Integer.parseInt(s.substring(i, i+2));
                i+=2;
            }else{
                index = s.charAt(i)-'0';
            }  
            char c = (char)(index+'a'-1);
            sb.append(c);
        }
        return sb.toString();
    }
}
```
# Backward
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while(i >= 0){
            char c = s.charAt(i);
            int val;
            if(c == '#'){
                val = Integer.parseInt(s.substring(i-2, i));
                i -= 3;
            }else{
                val = Integer.parseInt(String.valueOf(c));
                i--;
            }
            c = (char)('a'+val-1);
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
```