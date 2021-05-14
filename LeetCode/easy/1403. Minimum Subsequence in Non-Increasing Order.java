class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        var list = new ArrayList();
        int totalSum = 0, subSum = 0;
        for(int num: nums){
            pq.add(num);
            totalSum += num;
        }
        
        while(totalSum >= subSum){
            if(!pq.isEmpty()){
                int val = pq.poll();
                totalSum -= val;
                subSum += val;
                list.add(val);
            }
        }
        return list;
    }
}