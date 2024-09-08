# Count Pairs Of Similar Strings

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as length of words

```java
class Solution {
    public int similarPairs(String[] words) {
      List<int[]> countList = new ArrayList();
      for(int i = 0; i < words.length; i++){
        countList.add(getCount(words[i]));
      }
      int res = 0;
      for(int i = 0; i+1 < countList.size(); i++){
        for(int j = i+1; j < countList.size(); j++){
          if(isSimilar(countList.get(i), countList.get(j))){
            res++;
          }
        }
      }
      return res;
    }

    public boolean isSimilar(int[] a, int[] b){
      for(int i = 0; i < 26; i++){
        if(a[i] == 0 && b[i] == 0){
          continue;
        }
        if(a[i] == 0 || b[i] == 0){
          return false;
        }
      }
      return true;
    }

    public int[] getCount(String word){
      int[] res = new int[26];
      for(char c: word.toCharArray()){
        res[c-'a']++;
      }
      return res;
    }
}
```

- Time Complexity: O(NM)
- Space Complexity: O(N)
  - N as length of words
  - M as max length of word

```java
class Solution {
    public int similarPairs(String[] words) {
        HashMap<String, List<String>> map = new HashMap();
        for(String word: words){
            String key = usedCharacter(word);
            map.computeIfAbsent(key, x -> new ArrayList()).add(word);
        }
        int res = 0;
        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            int x = entry.getValue().size();
            if(x > 1){
                res += (x*(x-1))/2;
            }
        }
        return res;
    }

    private String usedCharacter(String word){
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[26];
        for(char c: word.toCharArray()){
            cnt[c-'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(cnt[i] > 0){
                sb.append(i+'a');
            }
        }
        return sb.toString();
    }
}
```
