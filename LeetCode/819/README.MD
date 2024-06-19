# Most Common Word

# HashMap, HashSet

- Time Complexity: O(Pw)
- Space Complexity: O(max(w, B))
  - P as length of paragraph
  - B as length of banned
  - w as length of word

```
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph + ".";
        HashMap<String, Integer> map = new HashMap();
        HashSet<String> set = new HashSet();
        for(String ban: banned){
            ban = ban.toLowerCase();
            set.add(ban);
        }
        StringBuilder sb = new StringBuilder();
        for(char c: paragraph.toCharArray()){
            if(c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z'){
                sb.append(c);
            }else{
                String word = sb.toString();
                sb = new StringBuilder();
                word = word.toLowerCase();
                if(set.contains(word) || word.equals("")){
                    continue;
                }
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        String res = "";
        int max = 0;
        for(String key: map.keySet()){
            if(max < map.get(key)){
                max = map.get(key);
                res = key;
            }
        }
        return res;
    }
}
```

# Regular Expression

- Time Complexity: O(PB)
- Space Complexity: O(max(P, B))
  - P as length of paragraph
  - B as length of banned

```
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("\\W+");
        HashMap<String, Integer> map = new HashMap();
        HashSet<String> bans = new HashSet();
        for(String ban: banned){
            bans.add(ban);
        }
        for(String word: words){
            if(!bans.contains(word)){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        int max = 0;
        String res = "";
        for(String w: map.keySet()){
            if(max < map.get(w)){
                max = map.get(w);
                res = w;
            }
        }
        return res;
    }
}
```
