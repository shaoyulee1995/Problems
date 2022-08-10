# HashSet
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of password
```
class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if(password.length() < 8){
            return false;
        }
        boolean lower = false,
                upper = false,
                digit = false,
                special = false;
        HashSet<Character> set = new HashSet(Arrays.asList('!','@','#','$','%','^','&','*','(',')','-','+'));
        for(int i = 0; i < password.length(); i++){
            char cur = password.charAt(i),
                 prev = (i > 0)? password.charAt(i-1): ' ';
            if(cur == prev){
                return false;
            }
            if(cur >= '0' && cur <= '9'){
                digit = true;
            }else if(cur >= 'a' && cur <= 'z'){
                lower =  true;
            }else if(cur >= 'A' && cur <= 'Z'){
                upper =  true;
            }
            if(set.contains(cur)){
                special = true;
            }
        }
        return lower && upper && digit && special;
    }
}
```