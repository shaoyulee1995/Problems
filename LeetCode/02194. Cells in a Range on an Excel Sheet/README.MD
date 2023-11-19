# String
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public List<String> cellsInRange(String s) {
        List<String> res = new ArrayList();
        String x = s.substring(0, 2),
               y = s.substring(3, s.length());
        for(char col = x.charAt(0); col <= y.charAt(0); col++){
            for(char row = x.charAt(1); row <= y.charAt(1); row++){
                res.add(""+col+row);
            }
        }
        return res;
    }
}
```