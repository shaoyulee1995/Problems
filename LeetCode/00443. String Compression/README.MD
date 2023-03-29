# String
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of chars
```
class Solution {
    public int compress(char[] chars) {
        int i = 0,
            idx = 0;
        while(i < chars.length){
            char c = chars[i];
            int count = 0;
            while(i < chars.length && chars[i] == c){
                count++;
                i++;
            }
            chars[idx++] = c;
            if(count > 1){
                for(char num: Integer.toString(count).toCharArray()){
                    chars[idx++] = num;
                }
            }
        }
        return idx;
    }
}
```