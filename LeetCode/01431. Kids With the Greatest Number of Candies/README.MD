# Array 
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N sa length of candies
```
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList();
        int max = Integer.MIN_VALUE;
        for(int c: candies){
            max = Math.max(max, c);
        }
        for(int c: candies){
            list.add((c+extraCandies >= max));
        }
        return list;
    }
}
```