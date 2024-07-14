# Partition Labels

# Sweep Line

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of s

```java
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] cnt = new int[26];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            cnt[c-'a'] = i;
        }
        List<Integer> list = new ArrayList();
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            end = Math.max(end, cnt[s.charAt(i)-'a']);
            if(i==end){
                list.add(end-start+1);
                start = end+1;
            }
        }
        return list;
    }
}
```
