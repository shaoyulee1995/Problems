# Remove Duplicate Letters

- Time Complexity: O(N)
- Space Complexity: O(N)

```
class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack();
        int[] words = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            words[c-'a']++;
        }
        for(char c: s.toCharArray()){
            words[c-'a']--;
            if(visited[c-'a']){
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > c && words[stack.peek() -'a'] != 0){
                char out = stack.pop();
                visited[out-'a'] = false;
            }
            stack.push(c);
            visited[c-'a'] = true;
        }
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
```
