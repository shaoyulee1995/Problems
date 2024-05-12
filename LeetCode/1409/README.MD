# Queries on a Permutation With Key
# LinkedList
* Time Complexity: O(Max(M, Q))
* Space Complexity: O(Max(M, Q))
	* M as m
	* Q as length of queries
```
class Solution {
    public int[] processQueries(int[] queries, int m) {
        LinkedList<Integer> list = new LinkedList();
        for(int i = 1; i <=m; i++){
            list.add(i);   
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int val = queries[i],
                index = list.indexOf(val);
            list.remove(index);
            list.add(0, val);
            ans[i] = index;
        }
        return ans;
    }
}
```