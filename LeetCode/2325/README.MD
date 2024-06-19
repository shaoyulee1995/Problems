# Decode the Message

# HashMap

- Time Complexity: O(Max(K, M))
- Space Complexity: O(26)
  - K as length of key
  - M as length of message

```
class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap();
        char indexA = 'a';
        for(char c: key.toCharArray()){
            if(c == ' '){
                continue;
            }
            if(!map.containsKey(c)){
                map.put(c, indexA++);
            }
        }
        map.put(' ', ' ');
        StringBuilder sb = new StringBuilder();
        for(char c: message.toCharArray()){
            sb.append(map.get(c));
        }
        return sb.toString();
    }
}
```

# Counting Array

- Time Complexity: O(Max(K, M))
- Space Complexity: O(26)
  - K as length of key
  - M as length of message

```
class Solution {
    public String decodeMessage(String key, String message) {
        int[] encode = new int[26];
        Arrays.fill(encode, -1);
        for(int i = 0, j = 0; i < key.length(); i++){
            char c = key.charAt(i);
            if(c == ' ' || encode[c-'a'] != -1){
                continue;
            }
            encode[c-'a'] = j++;
        }
        StringBuilder sb = new StringBuilder();
        for(char c: message.toCharArray()){
            if(c == ' '){
                sb.append(" ");
            }else{
                sb.append((char)(encode[c-'a']+'a'));
            }
        }
        return sb.toString();
    }
}
```
