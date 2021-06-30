class Solution {
    public String customSortString(String order, String str) {
        int[] cnt = new int[26];
        for(char c: str.toCharArray()){
            cnt[c -'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        int j = 0; 
        while(j < order.length()){
            char c = order.charAt(j);
            for(int i = 0; i < cnt[c-'a']; i++){
                sb.append(c);
            }
            cnt[c-'a'] = 0;
            j++;
        }
        for(int i = 0; i< 26; i++){
            for(int k = 0; k < cnt[i]; k++){
                sb.append("" + (char)('a'+ i));
            }
        }
        return sb.toString();
    }
}