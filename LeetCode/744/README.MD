# Find Smallest Letter Greater Than Target
# Binary Search
* Time Complexity: O(log(N))
* Space Complexity: O(1)
```
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if(target >= letters[letters.length-1]){
            return letters[0];
        }
        int i = 0, j = letters.length-1;
        while(i < j){
            int k = i + (j-i)/2;
            if(letters[k] <= target){
                i = k+1;
            }else{
                j = k;
            }
        }
        return letters[i];
    }
}
```
# Comparator
* Time Complexity: O(N)
* Space Complexity: O(1)
```
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans = ' ';
        for(char c: letters){
            if(c == target){
                continue;
            }
            if((ans == ' ' || ans > c) && target < c){
                ans = c;
            }
        }
        return (ans == ' ')? letters[0]: ans;
    }
}
```