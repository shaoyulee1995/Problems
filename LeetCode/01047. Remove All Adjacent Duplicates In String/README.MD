# String
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            int sb_size = sb.length();
            if(sb_size > 0 && sb.charAt(sb_size - 1) == c){
                sb.deleteCharAt(sb_size-1);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```