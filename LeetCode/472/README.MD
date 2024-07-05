# Concatenated Words

- Time Complexity: O(NW<sup>2</sup>)
- Space Complexity: O(N)
  - N as length of words
    - W as length of word

```
class Solution {
    List<String> res;
    HashMap<String, Boolean> map;
    HashSet<String> set;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        res = new ArrayList();
        map = new HashMap();
        set = new HashSet(Arrays.asList(words));
        for(String word: words){
            if(dfs(word)){
                res.add(word);
            }
        }
        return res;
    }

    public boolean dfs(String word){
        if(map.containsKey(word)){
            return map.get(word);
        }
        for(int i = 1; i < word.length(); i++){
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            if(set.contains(prefix) && (set.contains(suffix) || dfs(suffix))){
                map.put(word, true);
                return true;
            }
        }
        map.put(word, false);
        return false;
    }
}
```
