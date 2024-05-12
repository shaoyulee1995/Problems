# String Compression
# String
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of chars
```
class Solution {
    public int compress(char[] chars) {
        int i = 0,
            grpIdx = 0;
        while(i < chars.length){
            char c = chars[i];
            int freq = 0;
            while(i < chars.length && c == chars[i]){
                freq++;
                i++;
            }
            chars[grpIdx++] = c;
            if(freq > 1){
                for(char num: Integer.toString(freq).toCharArray()){
                    chars[grpIdx++] = num;
                }
            }
        }    
        return grpIdx;
    }
}
```