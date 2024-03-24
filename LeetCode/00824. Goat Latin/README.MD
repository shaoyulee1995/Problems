# Math
* Time Complexity: O(NWn)
* Space Complexity: O(N)
    * N as length of sentence
    * W as maximum length of word
    * n as size of words
```
class Solution {
    public String toGoatLatin(String sentence) {
        Set<Character> set = new HashSet(Arrays.asList('A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u'));
        String res = "";
        int i = 0;
        for(String s: sentence.split("\\s")){
            res += ' ' + (set.contains(s.charAt(0))? s: s.substring(1) + s.charAt(0)) + "ma";
            i++;
            for(int j = 0; j < i; j++){
                res += "a";
            }
        }
        return res.substring(1);
    }
}
```