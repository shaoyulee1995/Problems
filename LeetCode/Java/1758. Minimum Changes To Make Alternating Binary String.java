class Solution {
    public int minOperations(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)-'0'!= i%2){
                res++;
            }
        }
        return Math.min(res, s.length() - res);
    }
}