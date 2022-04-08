# Array
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of seq
```
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        int lvl = 0;
        for(int i = 0; i < seq.length(); i++){
            char c = seq.charAt(i);
            if(c == '('){
                res[i] = ++lvl%2;
            }else{
                res[i] = lvl--%2;
            }
        }
        return res;
    }
}
```