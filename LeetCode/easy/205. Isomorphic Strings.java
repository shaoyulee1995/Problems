class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] cnt1 = new int[256],
              cnt2 = new int[256];
        for(int i = 0; i < s.length(); i++){
            if(cnt1[s.charAt(i)] != cnt2[t.charAt(i)]){
                return false;
            }
            cnt1[s.charAt(i)] = i+1;
            cnt2[t.charAt(i)] = i+1;
        }
        return true;
    }
}