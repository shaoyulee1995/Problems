# Largest 3-Same-Digit Number in String

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of num

```java
class Solution {
    public String largestGoodInteger(String num) {
        Character c = null;
        for(int i = 1; i+1 < num.length(); i++){
            char x = num.charAt(i-1),
                 y = num.charAt(i),
                 z = num.charAt(i+1);
            if(x == y && y == z){
                if(c == null || c < x){
                    c = x;
                }
            }
        }
        return (c == null)? "": String.valueOf(c).repeat(3);
    }
}
```

- Time Complexity: O(1)
- Space Complexity: O(1)
  - N as length of num

```java
class Solution {
    public String largestGoodInteger(String num) {
        String[] numbers = {"999", "888", "777", "666", "555", "444", "333", "222", "111", "000"};
        for (String s : numbers) {
            if (num.indexOf(s) >= 0) {
                return s;
            }
        }
        return "";
    }
}
```