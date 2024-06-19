# String Matching in an Array

# String

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList();
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words.length; j++){
                if(i != j && words[j].indexOf(words[i]) != -1){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}
```
