# Maximum Score After Splitting a String

# String

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```
class Solution {
    public int maxScore(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            res = Math.max(res, compareScores(s.substring(0, i), s.substring(i)));
        }
        return res;
    }
    public int compareScores(String a, String b){
        if(a.length() == 0 || a.length() == 0){
            return 0;
        }
        return getZeros(a) + getOnes(b);
    }
    public int getZeros(String a){
        int res = 0;
        for(char c: a.toCharArray()){
            if(c == '0'){
                res++;
            }
        }
        return res;
    }
    public int getOnes(String a){
        int res = 0;
        for(char c: a.toCharArray()){
            if(c == '1'){
                res++;
            }
        }
        return res;
    }
}
```

# String

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of s

```
class Solution {
    public int maxScore(String s) {
        int ones = 0,
            zeros = 0,
            max = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                zeros++;
            }else{
                ones++;
            }
            if(i != s.length() - 1){
                max = Math.max(max, zeros - ones);
            }
        }
        return max + ones;
    }
}
```
