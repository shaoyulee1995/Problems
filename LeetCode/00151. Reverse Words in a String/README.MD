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
            j = s.length() - 1;
        while(i < s.length() && s.charAt(i) == ' '){
            i++;
        }
        while(j >= 0 && s.charAt(j) == ' '){
            j--;
        }
        StringBuilder sb = new StringBuilder();
        Deque<String> deque = new ArrayDeque();
        while(i <= j){
            char c = s.charAt(i);
            if(sb.toString().length() != 0 && c == ' '){
                deque.offerFirst(sb.toString());
                sb.setLength(0);
            }else if (c != ' '){
                sb.append(c);
            }
            i++;
        }
        deque.offerFirst(sb.toString());
        return String.join(" ", deque);
    }
}
```