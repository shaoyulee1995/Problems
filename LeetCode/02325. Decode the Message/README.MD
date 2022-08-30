# HashMap
* Time Complexity: O(Max(K, M))
* Space Complexity: O(26)
	* K as length of key
	* M as length of message
```
class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap();
        int idx = 0;
        for(char c: key.toCharArray()){
            if(c == ' ' || map.containsKey(c)){
                continue;
            }
            map.put(c, (char)('a'+(idx++)));
        }
        StringBuilder sb = new StringBuilder();
        for(char c: message.toCharArray()){
            sb.append((c == ' ')?' ': map.get(c));
        }
        return sb.toString();
    }
}
```