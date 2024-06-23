# Russian Doll Envelopes

# BinarySearch

- Time Complexity: O(NlogN)
- Space Complexity: O(N)

```
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
               if(a[0] == b[0]){
                   return b[1] - a[1];
               }
               return a[0] - b[0];
           }
        });

        int[] dp = new int[envelopes.length];
        int pos = 0;
        for(int[] envelop: envelopes){
            int i = Arrays.binarySearch(dp, 0, pos, envelop[1]);
            if(i < 0){
                i = Math.abs(i) - 1;
            }
            dp[i] = envelop[1];
            if(i == pos){
                pos++;
            }
        }
        return pos;
    }
}
```

# BinarySearch

- Time Complexity: O(NlogN)
- Space Complexity: O(N)

```
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b)-> (a[0] == b[0])?b[1]-a[1]:a[0]-b[0]);
        int[] height = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++){
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }
    public int lengthOfLIS(int[] nums){
        int piles = 0, n = nums.length;
        int[] top = new int[n];
        for(int i = 0; i < n; i++){
            int poker = nums[i];
            int left = 0, right = piles;
            while(left < right){
                int mid = left + (right - left)/2;
                if(top[mid] < poker){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            if(piles == left){
                piles++;
            }
            top[left] = poker;
        }
        return piles;
    }
}
```
