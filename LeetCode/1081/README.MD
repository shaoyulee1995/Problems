# Smallest Subsequence of Distinct Characters

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```
class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[26];
        int[] cnt = new int[26];
        for(char c: s.toCharArray()){
            cnt[c-'a']++;
        }
        for(char c: s.toCharArray()){
            cnt[c-'a']--;
            if(visited[c-'a']){
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > c && cnt[stack.peek() - 'a'] != 0){
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
