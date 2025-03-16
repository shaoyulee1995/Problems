# Word Pattern

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
    - N as length of s

```java
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if(strs.length != pattern.length()){
            return false;
        }
        HashMap<Character, String> map = new HashMap();
        for(int i = 0; i < strs.length; i++){
            String word = strs[i];
            char index = pattern.charAt(i);
            if(map.containsKey(index)){
                if(!map.get(index).equals(word)){
                    return false;
                }
            }else{
                if(map.containsValue(word)){
                    return false;
                }
                map.put(index, word);
            }
        }
        return true;
    }
} }
}
```
