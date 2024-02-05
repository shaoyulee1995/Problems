# HashMap
* Time Complexity: O(WN)
* Space Complexity: O(WN)
	* W is the length of words string
	* N is the length of each word
```
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] p = getPattern(pattern);
        List<String> res = new ArrayList();
        for(String word: words){
            if(Arrays.equals(getPattern(word), p)){
                res.add(word);
            }
        }
        return res;
    }

    public int[] getPattern(String word){
        int[] res = new int[word.length()];
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0; i < word.length(); i++){
            map.putIfAbsent(word.charAt(i), map.size());
            res[i] = map.get(word.charAt(i));
        }
        return res;
    }
}
```