Time Complexity: O(N)
<br />
Space Complexity: O(N)
```
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int start = 0, end = 0;
        List<String> list = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            while(i < nums.length -1 && nums[i] + 1 == nums[i+1]){
                i++;
                end++;
            }
            if(start == end){
                list.add(new String(""+nums[start]));
            }else{
                list.add(new String(nums[start]+"->"+nums[end]));
            }
            end++;
            start = end;
        }
        return list;
    }
}
```
