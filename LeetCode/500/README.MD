# Keyboard Row

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of words

```java
class Solution {
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList();
        Set<Character> firstRow = toSet("qwertyuiop"),
                       secondRow = toSet("asdfghjkl"),
                       thirdRow = toSet("zxcvbnm");
        for(String word: words){
          Set<Character> inputs = toSet(word.toLowerCase());
          if(firstRow.containsAll(inputs) || secondRow.containsAll(inputs) || thirdRow.containsAll(inputs)){
            res.add(word);
          }
        }
        return res.toArray(String[]:: new);
    }

    public Set<Character> toSet(String word){
      return word.chars().mapToObj(c->(char)c).collect(Collectors.toSet());
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of words

```java
class Solution {
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList();
        int[] rows = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
        for(String word: words){
          String input = word.toLowerCase();
          int targetRow = rows[input.charAt(0)-'a'];
          boolean isSame = true;
          for(char c: input.toCharArray()){
              if(rows[c-'a'] != targetRow){
                  isSame = false;
                  break;
              }
          }
          if(isSame){
              res.add(word);
          }
        }
        return res.toArray(String[]:: new);
    }
}
```
