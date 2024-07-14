# Remove Letter To Equalize Frequency

- Time Complexity: O(W)
- Space Complexity: O(26)
  - W as length of word

```java
class Solution {
    public boolean equalFrequency(String word) {
        int[] cnt = new int[26];
        for(char c: word.toCharArray()){
            cnt[c-'a']++;
        }
        for(int i = 0; i < 26; i++){
            cnt[i]--;
            if(equalFreq(cnt)){
                return true;
            }
            cnt[i]++;
        }
        return false;
    }

    public boolean equalFreq(int[] arr){
        int cnt = 0;
        for(int a: arr){
            if(a == 0 || cnt == a){
                continue;
            }else if(cnt == 0){
                cnt = a;
            }else{
                return false;
            }
        }
        return true;
    }
}

```
