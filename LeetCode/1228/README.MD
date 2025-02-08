# Missing Number In Arithmetic Progression

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as the length of the array

```java
class Solution {
    public int missingNumber(int[] arr) {
        int diff = (arr[arr.length-1] - arr[0])/arr.length,
            expect = arr[0];
        for(int a: arr){
            if(a != expect){
                return expect;
            }
            expect += diff;
        }
        return expect;
    }
}z
```

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as the length of the array

```java
class Solution {
    public int missingNumber(int[] arr) {
        int diff = (arr[arr.length-1] - arr[0])/arr.length,
            i = 0,
            j = arr.length;
        while(i < j){
            int k = i + (j-i)/2;
            if(arr[k] == arr[0] + diff*k){
                i = k+1;
            }else{
                j = k;
            }
        }
        return arr[0] + i*diff;
    }
}
```
