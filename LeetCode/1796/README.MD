# Second Largest Digit in a String
# TreeSet
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of s
```
class Solution {
    public int secondHighest(String s) {
        TreeSet<Integer> set = new TreeSet<>();
        for(char c: s.toCharArray()){
            if(c >='0' && c <='9'){
                set.add((Integer)(c-'0'));
            }
        }
        set = (TreeSet)set.descendingSet();
        if(set.size() <= 1){
            return -1;
        }
        set.pollFirst();
        return set.pollFirst();
    }
}
```
# Math
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of s
```
class Solution {
    public int secondHighest(String s) {
        int max1 = Integer.MIN_VALUE,
            max2 = Integer.MIN_VALUE;
        for(char c: s.toCharArray()){
            if(!Character.isDigit(c)){
                continue;
            }
            int digit = c - '0';
            if(digit > max1){
                max2 = max1;
                max1 = digit;
            }else if(digit > max2){
                if(digit != max1){
                    max2 = digit;
                }
            }
        }
        return max2 == Integer.MIN_VALUE? -1: max2;
    }
}
```