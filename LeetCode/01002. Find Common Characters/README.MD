# Counting Array
* Time Complexity: O(W)
* Space Complexity: O(26)
	* W as length of words	
```
class Solution {
    public List<String> commonChars(String[] words) {
        int[] common = new int[26];
        Arrays.fill(common, Integer.MAX_VALUE);
        for(String word: words){
            int[] cnt = new int[26];
            for(char c: word.toCharArray()){
                cnt[c-'a']++;
            }
            for(int i = 0; i < 26; i++){
                common[i] = Math.min(common[i], cnt[i]);
            }
        }
        List<String> res = new ArrayList();
        for(int i = 0; i < 26; i++){
            while(common[i]-- > 0){
                res.add(String.valueOf((char)('a'+i)));
            }
        }
        return res;
    }
}
```