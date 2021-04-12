class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int maxSum = A[0],
            minSum = A[0],
            curMax = 0,
            curMin = 0,
            total = 0;
        
        for(int a: A){
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        
        return maxSum > 0? Math.max(total-minSum, maxSum):maxSum;
        
    }
}