# Strong Password Checker II

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of password

```java
class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if(password.length() < 8){
          return false;
        }
        HashSet<Character> specialSet = new HashSet();
        for(char c: "!@#$%^&*()-+".toCharArray()){
          specialSet.add(c);
        }
        boolean upper = false,
                lower = false,
                digit = false,
                special = false;
        for(int i = 0; i < password.length(); i++){
          char c = password.charAt(i);
          if(i > 0 && c == password.charAt(i-1)){
            return false;
          }
          if(Character.isDigit(c)){
            digit = true;
          }else if(Character.isUpperCase(c)){
            upper = true;
          }else if(Character.isLowerCase(c)){
            lower = true;
          }else if(specialSet.contains(c)){
            special = true;
          }
        }
        return upper && lower && digit && special;
    }
}


```
