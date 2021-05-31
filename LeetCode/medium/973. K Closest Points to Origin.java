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