# Longest Nice Substring
# Divide and conquer
* Time Complexity: O(N<sup>2</sup>)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public String longestNiceSubstring(String s) {
      if(s.length() < 2){
        return "";
      }
      HashSet<Character> set = new HashSet();
      for(char c: s.toCharArray()){
        set.add(c);
      }
      for(int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        if(set.contains(Character.toUpperCase(c)) && 
          set.contains(Character.toLowerCase(c))){
            continue;
          }
        String a = longestNiceSubstring(s.substring(0, i)),
               b = longestNiceSubstring(s.substring(i+1));
        return (a.length() >= b.length())? a: b;
      }
      return s;
    }
}
```