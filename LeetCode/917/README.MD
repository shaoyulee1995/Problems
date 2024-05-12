# Reverse Only Letters
# String
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0,
            j = s.length()-1;
        while(i < j){
            if(!Character.isLetter(s.charAt(i))){
                i++;
            }else if(!Character.isLetter(s.charAt(j))){
                j--;
            }else{
                sb.setCharAt(i, s.charAt(j));
                sb.setCharAt(j, s.charAt(i));
                i++;
                j--;
            }  
        }
        return sb.toString();
    }
}
```