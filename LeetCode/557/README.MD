# Reverse Words in a String III
# String 1
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for(String word: words){
            sb.append(new StringBuilder(word).reverse().toString()+" ");
        }
        return sb.toString().trim();
    }
}
```
# String 2
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            for(int i = str.length() - 1; i >= 0; i--){
                char c= str.charAt(i);
                sb.append(c);
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
```