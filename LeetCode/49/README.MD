# Group Anagrams

- Time Complexity: O(Nwlog(w))
- Space Complexity: O(N)
  - N as length of strs
  - w as length of w

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();

        for(String str: strs){
            char[] word = str.toCharArray();
            Arrays.sort(word);
            String key = new String(word);
            map.computeIfAbsent(key, x -> new ArrayList()).add(str);
        }
    
        List<List<String>> res = new ArrayList();
        for(List<String> value: map.values()){
            res.add(value);
        }
        return res;
    }
}
```
