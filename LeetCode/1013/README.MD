# Partition Array Into Three Parts With Equal Sum

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of arr

```java
class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum(),
            avg = sum/3;
        if(sum%3 != 0){
            return false;
        }
        int i = 0,
            j = arr.length-1,
            leftSum = arr[i++],
            rightSum = arr[j--];
        do{
            if(leftSum != avg){
                leftSum += arr[i++];
            }
            if(rightSum != avg){
                rightSum += arr[j--];
            }
            if(i <= j && leftSum == avg && rightSum == avg){
                return true;
            }
        }while(i < j);
        return false;
    }
}
```
