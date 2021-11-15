# Counting Sort
* Time Complexity: O(N)
* Space Complexity: O(26)
```
class Solution {
    public int minSteps(String s, String t) {
        int[] cnt = new int[26];
        
        for(char c: s.toCharArray()){
            cnt[c-'a']++;
        }
        int sum = 0;
        for(char c: t.toCharArray()){
            if(cnt[c-'a']>0){
                --cnt[c-'a'];
            }else{
                sum++;
            }
        }
        return sum;
    }
}
```