# Split Strings by Separator

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as the length of words

```java
class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList();
        for(String word: words){
            StringBuilder sb = new StringBuilder();
            for(char c: word.toCharArray()){
                if(c == separator){
                    if(sb.length() > 0){
                        res.add(sb.toString());
                    }
                    sb.setLength(0);
                }else{
                    sb.append(c);
                }
            }
            if(sb.length() > 0){
                res.add(sb.toString());
            }

        }
        return res;
    }
}
```