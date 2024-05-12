# Maximum Number of Words You Can Type
# Set
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of text
```
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet();
        for(char c: brokenLetters.toCharArray()){
            set.add(c);
        }
        String[] words = text.split(" ");
        int res = 0;
        for(String word: words){
            boolean broken = false;
            for(char c: word.toCharArray()){
                if(set.contains(c)){
                    broken = true;
                    break;
                }
            }
            if(!broken){
                res++;
            }
        }
        return res;
    }
}
```