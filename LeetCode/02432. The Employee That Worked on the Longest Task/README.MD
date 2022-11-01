# Math
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of logs
```
class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int id = logs[0][0],
            res = logs[0][1];
        for(int i = 1; i < logs.length; i++){
            int curlen = logs[i][1] -  logs[i-1][1]; 
            if(curlen > res || curlen == res && id > logs[i][0]){
                res = curlen;
                id = logs[i][0];
            }
        }
        return id;
    }
}
```