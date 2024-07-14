# Truncate Sentence

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public String truncateSentence(String s, int k) {
        String[] parse = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < k; i++){
            if(k == i + 1){
                sb.append(parse[i]);
                break;
            }
            sb.append(parse[i] + " ");
        }
        return sb.toString();
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int space = 0;
        for(char c: s.toCharArray()){
            if(c == ' '){
                space++;
            }
            if(space == k){
                return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
```
