# Triangle
# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of triangle
    * M as length of triangle[0]
```
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] sum = new int[triangle.size()+1];
        for(int i = triangle.size()-1; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                sum[j] = Math.min(sum[j], sum[j+1]) + triangle.get(i).get(j);
            }
        }
        return sum[0];
    }
}
```