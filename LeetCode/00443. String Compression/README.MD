# String
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of chars
```
class Solution {
    public int compress(char[] chars) {
        int i = 0,
            n = chars.length,
            idx = 0;
        while(i < n){
            final char c = chars[i];
            int cnt = 0;
            while(i < n && c == chars[i]){
                cnt++;
                i++;
            }
            chars[idx++] = c;
            if(cnt > 1){
                char[] nums = String.valueOf(cnt).toCharArray();
                for(char num: nums){
                    chars[idx++] = num;
                }
            }
        }
        return idx;
    }
}
```