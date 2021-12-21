# Two Pointers
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public void reverseString(char[] s) {
        int i = 0,
            j = s.length - 1;
        while(i < j){
            char head = s[i],
                 end = s[j];
            char temp = head;
            s[i] = end;
            s[j] = temp;
            i++;
            j--;
        }
    }
}
```