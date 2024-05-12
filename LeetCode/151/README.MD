# Reverse Words in a String
# String
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            if(str.length() == 0){
                continue;
            }
            sb.insert(0, str.toCharArray());
            sb.insert(0, " ");
        }
        return sb.toString().trim();
    }
}
```
# Deque
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public String reverseWords(String s) {
        int i = 0,
            j = s.length()-1;
        while(i < j && s.charAt(i) == ' '){
            i++;
        }
        while(j >= i && s.charAt(j) == ' '){
            j--;
        }
        ArrayDeque<String> deque = new ArrayDeque();
        StringBuilder sb = new StringBuilder();
        while(i <= j){
            char c = s.charAt(i);
            if(c != ' '){
                sb.append(c);
            }else if(c == ' ' && sb.length() != 0){
                deque.offerFirst(sb.toString());
                sb.setLength(0);
            }
            i++;
        }
        deque.offerFirst(sb.toString());
        return String.join(" ", deque);
    }
}
```