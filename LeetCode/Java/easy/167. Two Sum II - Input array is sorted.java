class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        
        while(i < j){
            int val = numbers[i] + numbers[j];
            if(val == target){
                return new int[]{i+1,j+1};
            }
            if(val < target){
                i++;
            }else{
                j--;
            }
        }
        return new int[]{};
    }
}

/*
 
2,7,11,15    target = 9
i
  j
        

*/