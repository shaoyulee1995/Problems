# String
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for(String word: words){
            sb.append(new StringBuilder(word).reverse().toString()+" ");
        }
        return sb.toString().trim();
    }
}
```