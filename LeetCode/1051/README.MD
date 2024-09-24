# Height Checker

- Time Complexity: O(HLog(H))
- Space Complexity: O(H)
  - H as length of heights

```java
class Solution {
    public int heightChecker(int[] heights) {
        int[] copy = heights.clone();
        int cnt = 0;
        Arrays.sort(copy);
        for(int i = 0; i < heights.length; i++){
            if(heights[i] != copy[i]){
                cnt++;
            }
        }
        return cnt;
    }
}
```

# Counting Sort

- Time Complexity: O(H)
- Space Complexity: O(1)
  - H as length of heights

```java
class Solution {
    public int heightChecker(int[] heights) {
        int[] cnt = new int[101];
        for(int h: heights){
            cnt[h]++;
        }
        int h = 0, ans = 0;
        for(int i = 0; i < heights.length; i++){
            while(cnt[h] == 0){
                h++;
            }
            if(h != heights[i]){
                ans++;
            }
            cnt[h]--;
        }
        return ans;
    }
}
```
