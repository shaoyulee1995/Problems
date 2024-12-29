# Circular Sentence

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of sentence

```java
class Solution {
    public boolean isCircularSentence(String sentence) {
        if(sentence.charAt(0) != sentence.charAt(sentence.length()-1)){
            return false;
        }
        if(sentence.indexOf(" ") < 0){
            return true;
        }
        for(int i = 0; i < sentence.length(); i++){
            if(sentence.charAt(i) == ' '){
                char prev = sentence.charAt(i-1),
                     next = sentence.charAt(i+1);
                if(prev != next){
                    return false;
                }   
            }
        }
        return true;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of sentence

```java
class Solution {
    public boolean isCircularSentence(String sentence) {
        if(sentence.charAt(0) != sentence.charAt(sentence.length()-1)){
            return false;
        }
        if(sentence.indexOf(" ") < 0){
            return true;
        }
        int spaceIndex = sentence.indexOf(" ");
        while(spaceIndex != -1){
            char prev = sentence.charAt(spaceIndex-1),
                 next = sentence.charAt(spaceIndex+1);
            if(prev != next){
                return false;
            }
            spaceIndex = sentence.indexOf(" ", spaceIndex+1);
        }
        return true;
    }
}
```