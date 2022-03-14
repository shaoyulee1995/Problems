# Array
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public int minPartitions(String n) {
        int res = 0;
        for(char c: n.toCharArray()){
            res = Math.max(c-'0', res);
        }
        return res;
    }
}
```