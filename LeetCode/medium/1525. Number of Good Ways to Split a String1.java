class Solution {
    public int numSplits(String s) {
        int[] leftCnt = new int[26],
              rightCnt = new int[26];
        int res = 0;
        for(char c: s.toCharArray()){
            rightCnt[c-'a']++;
        }
        for(char c: s.toCharArray()){
            leftCnt[c-'a']++;
            rightCnt[c-'a']--;
            
            int cntLeftChar = getCnt(leftCnt),
                cntRightChar = getCnt(rightCnt);
            if(cntLeftChar == cntRightChar){
                res++;
            }
        }
        return res;
    }
    private int getCnt(int[] cnt){
        int res = 0;
        for(int num: cnt){
            if(num != 0){
                res++;
            }
        }
        return res;
    }
}