# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        int freq = 1;
        sb.append(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == prev){
                freq++;
            }else{
                prev = c;
                freq = 1;
            }
            if(freq < 3){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```