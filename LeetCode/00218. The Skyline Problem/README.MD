# Sweep Line
* Time Complexity: O(NlogN)
* Space Complexity: O(N)
```
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList();
        List<int[]> height = new ArrayList();
        for(int[] building: buildings){
            height.add(new int[]{building[0], -building[2]});
            height.add(new int[]{building[1], building[2]});
        }
        Collections.sort(height, (a, b) -> (a[0] != b[0])?a[0] - b[0]: a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        pq.offer(0);
        int preMax = 0;
        for(int[] b: height){
            if(b[1] < 0){
                pq.add(-b[1]);
            }else{
                pq.remove(b[1]);
            } 
            int curMax = pq.peek();
            if(curMax != preMax){
                res.add(List.of(b[0], curMax));
                preMax = curMax;
            }
        }
        return res;
    }
}
```