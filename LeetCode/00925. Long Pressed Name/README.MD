# Array
* Time Complexity: O(Max(N,M))
* Space Complexity: O(1)
    * N as length of name
    * M as length of typed
```
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(name.equals(typed)){
            return true;
        }    
        int i = 0;
        for(int j = 0; j < typed.length(); j++){
            if(i < name.length() && name.charAt(i) == typed.charAt(j)){
                i++;
            }else if(j == 0 || typed.charAt(j) != typed.charAt(j-1)){
                return false;
            }
        }
        return i == name.length();
    }
}
```