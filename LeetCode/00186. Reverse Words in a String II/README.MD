# 2 Pointers
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of s
```
class Solution {
    public void reverseWords(char[] s) {
        int i = 0, 
            j = 0;
        reverse(s, 0, s.length-1);
        while(i < s.length && j < s.length){
            while(i < s.length && s[i] == ' '){
                i++;
            }
            j = i;
            while(j < s.length && s[j] != ' '){
                j++;
            }
            reverse(s, i, j-1);
            i = j;
        }
    }

    public void reverse(char[] s, int i, int j){
        while(i <= j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
```