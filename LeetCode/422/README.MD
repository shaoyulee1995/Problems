# Valid Word Square

- Time Complexity: O(NM)
- Space Complexity: O(N)
  - N as row of words
  - M as col of word

```java
class Solution {
    public boolean validWordSquare(List<String> words) {
        int n = words.size();
        for(int i = 0; i < n; i++){
            String word = words.get(i);
            if(!getString(i, words).equals(word)){
                return false;
            }
        }
        return true;
    }
    public String getString(int i, List<String> words){
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < words.size(); j++){
            String word = words.get(j);
            if(i < word.length()){
                sb.append(word.charAt(i));
            }
        }
        return sb.toString();
    }
}
```

- Time Complexity: O(NM)
- Space Complexity: O(1)
  - N as row of words
  - M as col of word

```java
class Solution {
    public boolean validWordSquare(List<String> words) {
        for(int i = 0; i < words.size(); i++){
            for(int j = 0; j < words.get(i).length(); j++){
                if(j >= words.size() || i >= words.get(j).length() || words.get(i).charAt(j) != words.get(j).charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
```
