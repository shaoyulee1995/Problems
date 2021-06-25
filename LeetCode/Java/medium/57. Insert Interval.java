class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList();
        
        int start = newInterval[0],
            end = newInterval[1],
            index = 0;
        while(index < intervals.length && intervals[index][1] < start){
            result.add(intervals[index]);
            index++;
        }
        while(index < intervals.length && intervals[index][0] <= end){
            start = Math.min(start, intervals[index][0]);
            end = Math.max(end, intervals[index][1]);
            index++;
        }
        result.add(new int[]{start, end});
        while(index < intervals.length){
            result.add(intervals[index]);
            index++;
        }
        return result.toArray(new int[0][]);
    }
}