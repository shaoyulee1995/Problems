class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] cnt = new int[2002];
        
        for(int num: arr){
            cnt[num+1000]++;
        }
    
        Set<Integer> set = new HashSet();
        
        for(int num: cnt){
            if(!set.add(num) &&num!=0){
                return false;
            }
        }
        return true;
    }
}