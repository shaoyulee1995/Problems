class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] cnt = new int[26];
        for(int i = 0; i < s.length(); i++){
            cnt[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList();
        int start = 0, end = -1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            end = Math.max(end, cnt[c-'a']);
            if(end == i){
                int length = end - start + 1;
                start = end + 1;
                ans.add(length);
            }
        }
        return ans;
    }
}