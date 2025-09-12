# The Two Sneaky Numbers of Digitville

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] cnt = new int[101];
        for(int num: nums){
            cnt[num]++;
        }
        List<Integer> sizeOfTwo = new ArrayList();
        for(int i = 0; i <= 100; i++){
            if(cnt[i] == 2){
                sizeOfTwo.add(i);
            }
        }
        return sizeOfTwo.stream().mapToInt(Integer::intValue).toArray();
    }
}
```