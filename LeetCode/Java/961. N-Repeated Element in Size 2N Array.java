class Solution {
    public int repeatedNTimes(int[] A) {
        int[] cnt = new int[10000];
        
        for(int a: A){
            cnt[a]++;
            if(cnt[a] == 2){
                return a;
            }
        }
        return 0;
    }
}