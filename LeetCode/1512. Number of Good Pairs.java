class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        int pairs = 0;
        for(int n:nums){
            pairs += count[n]++;
        }
        return pairs;
    }
}