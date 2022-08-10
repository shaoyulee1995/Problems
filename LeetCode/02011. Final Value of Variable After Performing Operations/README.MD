# String
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of operations
```
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for(String operation: operations){
            char c = operation.charAt(1);
            if(c == '-'){
                res -= 1;
            }else if(c == '+'){
                res += 1;
            }
        }
        return res;
    }
}
```