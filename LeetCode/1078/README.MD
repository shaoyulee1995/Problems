# Occurrences After Bigram

# Array

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of text

```
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> res = new ArrayList();
        String[] words = text.split(" ");
        for(int i = 1; i+1< words.length; i++){
            if(words[i-1].equals(first) && words[i].equals(second)){
                res.add(words[i+1]);
            }
        }
        return res.stream().toArray(String[]::new);
    }
}
```
