# Longest Substring with At Least K Repeating Characters

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        if(k < 2){
            return s.length();
        }
        return dfs(s, 0, s.length(), k);
    }

    public int dfs(String s, int l, int r, int k){
        if(l >= r){
            return 0;
        }
        int[] cnt = new int[26];
        for(int i = l; i < r; i++){
            cnt[s.charAt(i) - 'a']++;
        }
        boolean flag = true;
        for(int i = 0; i < 26; i++){
            if(cnt[i] > 0 && cnt[i] < k){
                flag = false;
            }
        }
        if(flag){
            return r - l;
        }

        int res = 0,
            start = 0;
        for(int i = l; i < r; i++){
            if(cnt[s.charAt(i)-'a'] < k){
                res = Math.max(res, dfs(s, start, i, k));
                start = i + 1;
            }
        }
        res = Math.max(res, dfs(s, start, r, k));
        return res;
    }
}
```

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(1)
  - N as length of s

```java
class Solution {
    public int longestSubstring(String s, int k) {
        if(k < 2){
            return s.length();
        }
        return dfs(s, 0, s.length(), k);
    }
    public int dfs(String s, int start, int end, int k){
        if(start >= end){
            return 0;
        }
        int[] cnt = new int[26];
        for(int i = start; i < end; i++){
            cnt[s.charAt(i)-'a']++;
        }
        boolean flag = true;
        for(int i = 0; i < 26; i++){
            if(cnt[i] > 0 && cnt[i] < k){
                flag = false;
            }
        }
        if(flag){
            return end-start;
        }
        int pivot = start,
            res = 0;
        for(int i = start; i < end; i++){
            if(cnt[s.charAt(i)-'a'] == 0){
                continue;
            }
            if(cnt[s.charAt(i)-'a'] < k){
                res = Math.max(res, dfs(s, pivot, i, k));
                pivot = i+1;
            }
        }
        res = Math.max(res, dfs(s, pivot, end, k));
        return res;
    }
}
```