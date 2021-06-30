class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        LinkedList<int[]> list = new LinkedList();
        
        for(int[] interval: intervals){
            if(list.isEmpty() || list.getLast()[1] < interval[0]){//[2,6],[8,10]
                list.add(interval);
            }else{
                list.getLast()[1] = Math.max(interval[1], list.getLast()[1]);//[1,3],[2,6]
            }
        }
        return list.toArray(new int[0][]);
    }
}