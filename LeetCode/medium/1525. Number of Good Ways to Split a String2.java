class Solution {
    public int numSplits(String s) {
        int[] cntR = new int[26],
              cntL = new int[26];
        int uniqueR = 0, uniqueL = 0;
        for(char c: s.toCharArray()){
            if(++cntR[c-'a'] == 1){
                uniqueR++;
            }
        }
        int ans = 0;
        for(char c: s.toCharArray()){
            if(++cntL[c-'a'] == 1){
                uniqueL++;
            }
            if(--cntR[c-'a'] == 0){
                uniqueR--;
            }
            if(uniqueL == uniqueR){
                ans++;
            }
        }
        return ans;
    }
}