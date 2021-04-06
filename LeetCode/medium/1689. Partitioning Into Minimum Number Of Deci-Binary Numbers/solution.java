class Solution {
    public int minPartitions(String n) {
        int result = Integer.MIN_VALUE;
        for(char c: n.toCharArray()){
            result = Math.max(c-'0', result);
        }
        return result;
    }
}