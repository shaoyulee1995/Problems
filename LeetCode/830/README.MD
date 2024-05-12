# Positions of Large Groups
# Array
* Time Complexity: O(S<sup>2</sup>)
* Space Complexity: O(log<sub>3</sub>S)
	* S as length of s
```
class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList();
        for(int i = 0, j = 0; i < s.length(); i = j){
            while(j < s.length() && s.charAt(i) == s.charAt(j)){
                j++;
            }
            if(j-i >= 3){
                res.add(Arrays.asList(i, j-1));
            }
        }
        return res;
    }
}
```