# Element Appearing More Than 25% In Sorted Array

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as the length of arr

```java
class Solution {
    public int findSpecialInteger(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int a: arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
            if(map.get(a) > arr.length/4){
                return a;
            }
        }
        return -1;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as the length of arr
```java
class Solution {
    public int findSpecialInteger(int[] arr) {
        for(int i = 0, targetSize = arr.length/4; i < arr.length - targetSize; i++){
            if(arr[i] == arr[i+targetSize]){
                return arr[i];
            }
        }
        return -1;
    }
}
```

- Time Complexity: O(logN)
- Space Complexity: O(1)
  - N as the length of arr

```java
class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int[] candidates = new int[]{arr[n/4], arr[n/2], arr[n*3/4]};
        for(int candidate: candidates){
            int startIndex = lowerBound(arr, candidate);
            if(arr[startIndex] == arr[startIndex+n/4]){
                return candidate;
            }
        }
        return -1;
    }

    public int lowerBound(int[] arr, int target){
        int i = 0,
            j = arr.length-1;
        while(i < j){
            int k = i + (j-i)/2;
            if(arr[k] >= target){
                j = k;
            }else if(arr[k] < target){
                i = k+1;
            }
        } 
        return i;
    }
}
```