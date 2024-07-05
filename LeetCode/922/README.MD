# Sort Array By Parity II

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0;
        for(int num: nums){
            if(num%2 == 0){
                res[i] = num;
                i += 2;
            }
        }
        i = 1;
        for(int num: nums){
            if(num%2 == 1){
                res[i] = num;
                i += 2;
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int[] res = new int[nums.length];
        int even = 0,
            odd = 1;
        for(int num: nums){
            if(num%2 == 0){
                res[even] = num;
                even += 2;
            }else{
                res[odd] = num;
                odd += 2;
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        for(int odd = 1, even = 0; even < nums.length; even += 2){
            if(nums[even]%2 == 1){
                while(nums[odd]%2 == 1){
                    odd += 2;
                }
                swap(nums, odd, even);
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```
