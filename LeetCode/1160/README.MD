# Find Words That Can Be Formed by Characters
# Counting Array
* Time Complexity: O(WL)
* Space Complexity: O(26)
	* W as length of words
	* L as length of word
```
class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] cnt = new int[26];
        for(char c: chars.toCharArray()){
            cnt[c-'a']++;
        }
        int res = 0;
        for(String word: words){
            int[] wordCnt = new int[26];
            for(char c: word.toCharArray()){
                wordCnt[c-'a']++;
            }
            boolean check = match(wordCnt, cnt);
            if(check){
                res += word.length();
            }
        }
        return res;
    }
    public boolean match(int[] a, int[] b){
        for(int i = 0; i < a.length; i++){
            if(a[i] > b[i]){
                return false;
            }
        }
        return true;
    }
}
```