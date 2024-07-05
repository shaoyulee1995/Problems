# Minimum Number of Keypresses

- Time Complexity: O(Max(NlogN, S))
- Space Complexity: O(N)
  - S as length of s
  - N as 26

```
class Solution {
    public int minimumKeypresses(String s) {
        int[] cnt = new int[26];
        for(char c: s.toCharArray()){
            cnt[c-'a']++;
        }
        Arrays.sort(cnt);
        int num = 0,
            res = 0;
        for(int i = 25; i >= 0; i--){
            if(num < 9){
                res += cnt[i];
            }else if(num < 18){
                res += cnt[i] * 2;
            }else if(num < 27){
                res += cnt[i] * 3;
            }
            num++;
        }
        return res;
    }
}
```

# Counting Array Sort by lambda

- Time Complexity: O(Max(NlogN, S))
- Space Complexity: O(N)
  - S as length of s
  - N as 26

```
class Solution {
    public int minimumKeypresses(String s) {
        Integer[] freq = new Integer[26];
        Arrays.fill(freq, 0);
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        Arrays.sort(freq, (x, y) -> y-x);
        int res = 0;
        for(int i = 0; i < 26; i++){
            res += freq[i] * ((i+9)/9);
        }
        return res;
    }
}
```
