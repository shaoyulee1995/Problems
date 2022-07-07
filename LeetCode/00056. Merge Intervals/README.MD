# Arrays
* Time Complexity: O(Nlog(N))
* Space Complexity: O(N)
	* N as length of intervals
```
class Solution {
    public int[][] merge(int[][] ways) {
        Arrays.sort(ways, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> path = new LinkedList();
        for(int[] way: ways){
            if(path.isEmpty() || path.getLast()[1] < way[0]){
                path.add(way);
            }else{
                path.getLast()[1] = Math.max(path.getLast()[1], way[1]);
            }
        }
        return path.toArray(new int[0][]);
    }
}
```