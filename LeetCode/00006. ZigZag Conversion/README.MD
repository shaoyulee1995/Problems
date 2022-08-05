# LinkedList
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            sb[i] = new StringBuilder();
        }
        char[] words = s.toCharArray();
        int index = 0;
        while(index < words.length){
            for(int i = 0; i < numRows && index < words.length; i++){
                sb[i].append(words[index++]);
            }
            for(int i = numRows - 2; i > 0 && index < words.length; i--){
                sb[i].append(words[index++]);
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < sb.length; i++){
            res.append(sb[i]);
        }
        return res.toString();
    }
}
```