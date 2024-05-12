# Reducing Dishes
# Array
* Time Complexity: O(SlogS)
* Space Complexity: O(1)
	* S as length of satisfaction
```
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int res = 0;
        Arrays.sort(satisfaction);
        for(int total = 0, i = satisfaction.length-1; i >= 0 && total > -satisfaction[i]; i--){
            total += satisfaction[i];
            res += total;
        }
        return res;
    }
}
```