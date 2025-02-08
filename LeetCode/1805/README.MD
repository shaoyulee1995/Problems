# Number of Different Integers in a String

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as the length of the string

```java

class Solution {
    public int numDifferentIntegers(String word) {
        String[] strs = word.replaceAll("[a-zA-z]", " ").split("\\s+");
        HashSet<String> set = new HashSet();
        for(String str: strs){
            if(!str.isEmpty()){
                set.add(String.valueOf(str.replaceAll("^0*", "")));
            }
        }
        return set.size();
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as the length of the string

```java
class Solution {
    public int numDifferentIntegers(String word) {
        HashSet<String> set = new HashSet();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < word.length()){
            if(Character.isDigit(word.charAt(i))){
                while(i < word.length() && Character.isDigit(word.charAt(i))){
                    sb.append(word.charAt(i++));
                }
                set.add(removeLeadingZero(sb));
                sb.setLength(0);
            }
            i++;
        }
        return set.size();
    }
    public String removeLeadingZero(StringBuilder sb){
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
```
