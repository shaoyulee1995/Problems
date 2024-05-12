# K Closest Points to Origin
# Java 7 Comparator
* Time Complexity: O(NKlog(K))
* Space Complexity: O(K)
	* N as length of points
	* K as k
```
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]> (Comparator.comparing(
        a-> -(a[0] * a[0] + a[1] * a[1])));
        for(int[] p: points){
            pq.offer(p);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.toArray(new int[k][2]);
    }
}
```
# Lambda Comparator
* Time Complexity: O(NKlog(K))
* Space Complexity: O(K)
	* N as length of points
	* K as k
```
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->(b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
        for(int[] point: points){
            pq.add(point);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.toArray(int[][]:: new);
    }
}
```