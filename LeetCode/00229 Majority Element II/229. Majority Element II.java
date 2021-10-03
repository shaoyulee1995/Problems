class Solution {
    public List<Integer> majorityElement(int[] nums) {
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
        
        List<Integer> ans = new ArrayList();
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