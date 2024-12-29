# Sort Even and Odd Indices Independently

- Time Complexity: O(NlogN)
- Space Complexity: O(N)
  - N as the length of nums

```java
class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int[] odds = new int[nums.length/2],
              evens = new int[nums.length-odds.length];
        for(int i = 0, x = 0, y = 0; i < nums.length; i++){
            if(i%2 == 0){
                evens[x++] = nums[i];
            }else{
                odds[y++] = nums[i];
            }
        }
        Arrays.sort(odds);
        Arrays.sort(evens);
        for(int i = 0, x = 0, y = odds.length-1; i < nums.length; i++){
            if(i%2 == 0){
                nums[i] = evens[x++];
            }else{
                nums[i] = odds[y--];
            }
        }
        return nums;
    }
}
```