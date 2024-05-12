# Majority Element II
# Array
* Time Complexity: O(N)
* Space Complexity: O(1)
	* N as length of nums
```
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList();
        Integer x = null, 
                y = null,
                xCount = 0,
                yCount = 0;
        for(Integer num: nums){
            if(num.equals(x)){
                xCount++;
            }else if(num.equals(y)){
                yCount++;
            }else if(xCount == 0){
                xCount = 1;
                x = num;
            }else if(yCount == 0){
                yCount = 1;
                y = num;
            }else{
                xCount--;
                yCount--;
            }
        }
        xCount = 0; yCount = 0;
        for(int num: nums){
            if(num == x){
                xCount++;
            }else if(num == y){
                yCount++;
            }
        }
        if(xCount > nums.length / 3){
            ans.add(x);
        }
        if(yCount > nums.length / 3){
            ans.add(y);
        }
        System.gc();
        return ans;
    }
}
```