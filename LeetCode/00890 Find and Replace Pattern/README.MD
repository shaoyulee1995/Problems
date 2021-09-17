# HashMap
* Time Complexity: O(WN)
* Space Complexity: O(WN)
	* W is the length of words string
	* N is the length of each word
```
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] p = pattern(pattern);
        List<String> ans = new ArrayList();
        for(String word: words){
            if(Arrays.equals(p, pattern(word))){
                ans.add(word);
            }
        }
        return ans;
    }
    public int[] pattern(String word){
        int length = word.length();
        HashMap<Character, Integer> map = new HashMap();
        int[] res = new int[length];
        for(int i = 0; i < word.length(); i++){
            map.putIfAbsent(word.charAt(i), map.size());
            res[i] = map.get(word.charAt(i));
        }
        return res;
    }
}
```