# Sentence Similarity

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```
class Solution {
    public boolean areSentencesSimilar(String[] A, String[] B, List<List<String>> words) {
        if(A.length != B.length){
          return false;
        }
        Map<String, Set<String>> map = new HashMap();
        for(List<String> word: words){
          String p = word.get(0),
                 q = word.get(1);
          map.computeIfAbsent(p, v -> new HashSet<String>()).add(q);
          map.computeIfAbsent(q, v -> new HashSet<String>()).add(p);
        }
        for(int i = 0; i < A.length; i++){
          if(A[i].equals(B[i])){
            continue;
          }
          if(!map.containsKey(A[i])){
            return false;
          }
          if(!map.get(A[i]).contains(B[i])){
            return false;
          }
        }
        return true;
    }
}
```
