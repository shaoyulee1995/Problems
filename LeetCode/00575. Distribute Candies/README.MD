# Counting
* Time Complexity: O(N)
* Space Complexity: O(N)
```
class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet();
        for(int candy: candyType){
            set.add(candy);
        }
        return Math.min(set.size(), candyType.length/2);
    }
}
```