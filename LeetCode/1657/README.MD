# Determine if Two Strings Are Close

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as the length of word1 or word2

```java
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        int[] countMap1 = new int[26],
              countMap2 = new int[26];
        for(char c: word1.toCharArray()){
            countMap1[c-'a']++;
        } 
        for(char c: word2.toCharArray()){
            countMap2[c-'a']++;
        }
        if(!isArrayMatch(countMap1, countMap2, 26)){
            return false;
        }
        Arrays.sort(countMap1);
        Arrays.sort(countMap2);
        return Arrays.equals(countMap1, countMap2);
    }

    private boolean isArrayMatch(int[] a, int[] b, int size){
        for(int i = 0; i < size; i++){
            if(a[i] == 0 && b[i] > 0 || b[i] == 0 && a[i] > 0){
                return false;
            }
        }
        return true;
    }
}
```
- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as the length of word1 or word2

```java
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap(),
                                    map2 = new HashMap();
        for(char c: word1.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for(char c: word2.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        if(!map1.keySet().equals(map2.keySet())){
            return false;
        }
        List<Integer> freq1 = new ArrayList(map1.values()),
                      freq2 = new ArrayList(map2.values());
        Collections.sort(freq1);
        Collections.sort(freq2);
        return freq1.equals(freq2);
    }
}
```