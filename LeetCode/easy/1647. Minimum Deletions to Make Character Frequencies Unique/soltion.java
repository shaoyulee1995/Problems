class Solution {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        
        for(char c s.toCharArray()){
            cnt[c - 'a']++;
        }
        
        SetInteger set = new HashSet();
        int ans = 0;
        for(int i = 0; i  cnt.length; i++){
            int curfreq = cnt[i];
            if(curfreq == 0){
                continue;
            }
            while(set.contains(curfreq)){
                curfreq--;
                ans++;
            }
            if(curfreq  0)
                set.add(curfreq);
        }
        return ans;
    }
}