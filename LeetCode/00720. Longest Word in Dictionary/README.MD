# Set
* Time Complexity: O(NlogN)
* Space Complexity: O(N)
	* N as length of words
```
class Solution {
    public String longestWord(String[] words) {
        String res = "";
        Arrays.sort(words);
        Set<String> set = new HashSet();
        for(String word: words){
            if(!set.contains(word)){
                if(word.length() == 1 || set.contains(word.substring(0, word.length()-1))){
                    set.add(word);
                    if(word.length() > res.length()){
                        res = word;
                    }
                }
            }
        }
        return res;
    }
}
```