# Number of Valid Clock Times
# Math
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of time
```
class Solution {
    public int countTime(String time) {
        int res = 1;
        char[] t = time.toCharArray();
        if(t[4] == '?'){
            res *= 10;
        }
        if(t[3] == '?'){
            res *= 6;
        }
        if(t[0] == '?' && t[1] == '?'){
            res *= 24;
        }else{
            if(t[1] == '?'){
                if(t[0] == '2'){
                    res *= 4;
                }else{
                    res *= 10;
                }
            }else if(t[0] == '?'){
                if(t[1] >= '4'){
                    res *= 2;
                }else{
                    res *= 3;
                }
            }
        }
        return res;
    }
}
```