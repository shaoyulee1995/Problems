# Distribute Elements Into Two Arrays I
# Stack
* Time Complexity: O(N)
* Space Complexity: O(N)
    * N as length of nums
```
class Solution {
    public int[] resultArray(int[] nums) {
        Stack<Integer> arr1 = new Stack(),
                       arr2 = new Stack();
        arr1.push(nums[0]);
        arr2.push(nums[1]);
        for(int i = 2; i < nums.length; i++){
            if(arr1.peek() > arr2.peek()){
                arr1.push(nums[i]);
            }else{
                arr2.push(nums[i]);
            }
        }
        int[] res = new int[nums.length];
        int i = 0;
        for(int num: arr1){
            res[i++] = num;
        }
        for(int num: arr2){
            res[i++] = num;
        }
        
        return res;
    }
}
```