# Strobogrammatic Number

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of salary

```java
class Solution {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<Character, Character>(
          Map.of('0','0',
                '1','1',
                '8','8',
                '6','9',
                '9','6'));
        int i = 0,
            j = num.length() - 1;
        while(i <= j){
          char x = num.charAt(i++),
               y = num.charAt(j--);
          if(map.get(x) == null){
            return false;
          }
          if(map.get(x) != y){
            return false;
          }
        }
        return true;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of salary

```java
class Solution {
    public boolean isStrobogrammatic(String num) {
      for(int i = 0, j = num.length()-1; i <= j; i++, j--){
        if(!"00 11 88 696".contains(num.charAt(i)+""+num.charAt(j))){
          return false;
        }
      }
      return true;
    }
}
```
