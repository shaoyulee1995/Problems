# String
* Time Complexity: O(N)
* Space Complexity: O(N)
    * N as length of s
```
class Solution {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c == 'i'){
                sb = sb.reverse();
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```