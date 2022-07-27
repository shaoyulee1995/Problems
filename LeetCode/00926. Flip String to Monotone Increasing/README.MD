# DP
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of s
```
class Solution {
    public int minFlipsMonoIncr(String s) {
        int one_count = 0,
            dp = 0;
        for(char c: s.toCharArray()){
            if(c == '1'){
                one_count++;
            }else{
                dp = Math.min(dp+1, one_count);
            }
        }
        return dp;
    }
}
```