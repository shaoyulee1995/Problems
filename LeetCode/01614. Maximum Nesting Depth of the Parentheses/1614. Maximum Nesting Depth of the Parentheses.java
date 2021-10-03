class Solution {
    public int maxDepth(String s) {
        int count = 0, max = Integer.MIN_VALUE;
        for(char c: s.toCharArray()){
            if(c=='('){
                count++;
            }else if(c ==')'){
                count --;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}