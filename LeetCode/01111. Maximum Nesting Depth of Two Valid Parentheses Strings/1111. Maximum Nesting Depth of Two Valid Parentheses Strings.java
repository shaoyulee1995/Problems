class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        int lvl = 0;
        for(int i = 0; i < res.length; i++){
            if(seq.charAt(i) == '('){
                res[i] = ++lvl % 2;
            }else{
                res[i] = lvl--%2;
            }
        }
        return res;
    }
}