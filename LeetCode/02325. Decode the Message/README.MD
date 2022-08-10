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
        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            if(c == ' ' || map.containsKey(c)){
                continue;
            }
            map.put(c, (char)('a'+(idx++)));
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < message.length(); i++){
            char c = message.charAt(i);
            if(c == ' '){
                sb.append(' ');
            }else{
                sb.append(map.get(c));
            }
        }
        return sb.toString();
    }
}
```