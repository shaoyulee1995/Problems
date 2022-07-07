# String
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of s
```
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0,
            j = s.length() - 1;
        while(i < j){
            char a = s.charAt(i),
                 b = s.charAt(j);
            while(i < j && !validCharacter(a)){
                a = s.charAt(++i);
            }
            while(i < j && !validCharacter(b)){
                b = s.charAt(--j);
            }
            a = Character.toLowerCase(a);
            b = Character.toLowerCase(b);
            if(a != b){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public boolean validCharacter(char w){
        return w <= 'z' && w >= 'a' || 
               w <= 'Z' && w >= 'A' || 
               w <= '9' && w >= '0';
    }
}
```