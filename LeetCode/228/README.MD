# Summary Ranges

- Time Complexity: O(N)
- Space Complexity: O(N)
    - N as length of nums

```java
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList();
        int start = 0,
            end = 0;
        for(int i = 0; i < nums.length; i++){
            while(i < nums.length-1 && nums[i]+1 == nums[i+1]){
                i++;
                end++;
            }
            if(start == end){
                res.add(""+nums[start]);
            }else{
                res.add(""+nums[start]+"->"+nums[end]);
            }
            end++;
            start = end;
        }
        return res;
    }
}
```
