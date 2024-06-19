# Rearrange Spaces Between Words

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of text

```
class Solution {
    public String reorderSpaces(String text) {
        String[] words = text.trim().split("\\s+");
        int size = words.length;
        int spaces = (int)text.chars().filter(c -> c == ' ').count();
        int gap = (size <= 1)? 0: spaces/(size-1);
        int tailingSpaces = spaces - gap*(size-1);
        return String.join(" ".repeat(gap), words) + " ".repeat(tailingSpaces);
    }
}
```
