class Solution {
    public List<String> commonChars(String[] words) {
        int[] dict = getDict(words[0]);
        for(int i = 1; i < words.length; i++){
            compareDict(dict, getDict(words[i]));
        }
        return commonWord(dict);
    }
    public int[] getDict(String str){
        int[] cnt = new int[26];
        for(char c: str.toCharArray()){
            cnt[c-'a']++;
        }
        return cnt;
    }
    
    public void compareDict(int[] target, int[] other){
        for(int i = 0; i < 26; i++){
            if(other[i] < target[i]){
                target[i] = other[i];
            }
        }
    }
    
    public List<String> commonWord(int[] cnt1){
        List<String> ans = new ArrayList();
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < cnt1[i]; j++){
                ans.add(""+(char)('a'+i));
            }
        }
        return ans;
    }
}