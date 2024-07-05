# Crawler Log Folder

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of logs

```
class Solution {
    public int minOperations(String[] logs) {
        int res = 0;
        for(String log: logs){
            if(log.equals("./")){
                continue;
            }
            res = log.equals("../")? res-1: res+1;
            if(res < 0){
                res = 0;
            }
        }
        return res;
    }
}
```
