# Word Pattern

# HashMap

- Time Complexity: O(N^2)
- Space Complexity: O(N)

```
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap();
        String[] strs = s.split(" ");
        if(strs.length != pattern.length()){
            return false;
        }
        for(int i = 0; i < strs.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(strs[i])){
                    return false;
                }
            }else{
                if(map.containsValue(strs[i])){
                    return false;
                }
                map.put(c, strs[i]);
            }
        }
        return true;
    }
}
```
