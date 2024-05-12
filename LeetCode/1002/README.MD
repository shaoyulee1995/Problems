# Find Common Characters
# Counting Array
* Time Complexity: O(WC)
* Space Complexity: O(W)
	* W as length of words	
    * C as length of word
```
class Solution {
    public List<String> commonChars(String[] words) {
        int[] common = new int[26];
        Arrays.fill(common, Integer.MAX_VALUE);
        for(String word: words){
            int[] chars = new int[26];
            for(char c: word.toCharArray()){
                chars[c-'a']++;
            }
            for(int i = 0; i < 26; i++){
                common[i] = Math.min(common[i], chars[i]);
            }
        }
        List<String> res = new ArrayList();
        for(int i = 0; i < 26; i++){
            while(common[i] > 0){
                res.add(String.valueOf((char)('a'+i)));
                common[i]--;
            }
        }
        return res;
    }
}
```