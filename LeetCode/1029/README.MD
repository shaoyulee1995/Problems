# Two City Scheduling
# Sorted
* Time Complexity: O(Clog(C))
* Space Complexity: O(1)
	* C as length of costs
```
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b)-> (a[0]-a[1]) - (b[0] - b[1]));
        System.out.println(Arrays.deepToString(costs));
        int res = 0;
        for(int i = 0; i < costs.length; i++){
            if(2*i < costs.length){
                res += costs[i][0];
            }else{
                res += costs[i][1];
            }
        }
        return res;
    }
}
```