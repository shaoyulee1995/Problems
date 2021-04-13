class Solution {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        
        for(char c: s.toCharArray()){
            cnt[c-'a']++;
        }
        
        Set<Integer> set = new HashSet();
        int ans = 0;
        for(int i = 0; i < 26; i++){
            if(cnt[i] == 0){
                continue;
            }
            
            while(set.contains(cnt[i])){
                cnt[i]--;
                ans++;
            }
            
            if(cnt[i]>0){
                set.add(cnt[i]);
            }
        
        }
        
        return ans;
        
    }
}