# Array
* Time Complexity: O(N+M)
* Space Complexity: O(1)
```
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(name.equals(typed)){
            return true;
        }
        int i = 0, m = name.length(), n = typed.length();
        for(int j = 0; j < n; j++){
            if(i < m && name.charAt(i) == typed.charAt(j)){
                i++;
            }else if(j == 0 || typed.charAt(j) != typed.charAt(j-1)){
                return false;
            }
        }
        return i == m;
    }
}
```