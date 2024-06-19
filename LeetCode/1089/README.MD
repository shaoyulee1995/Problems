# Duplicate Zeros

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of arr

```java
class Solution {
    public void duplicateZeros(int[] arr) {
        Queue<Integer> queue = new LinkedList();
        for(int a: arr){
            queue.offer(a);
        }
        int i = 0;
        while(i < arr.length){
            int val = queue.poll();
            arr[i++] = val;
            if(i < arr.length && val == 0){
                arr[i++] = 0;
            }
        }
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of arr

```java
class Solution {
    public void duplicateZeros(int[] arr) {
        int zeroCounts = 0;
        for(int a: arr){
            zeroCounts += (a == 0)? 1: 0;
        }
        int prediction_len = arr.length + zeroCounts;

        for(int i = arr.length-1, j = prediction_len-1; i < j; i--, j--){
            if(arr[i] != 0){
                if(j < arr.length){
                    arr[j] = arr[i];
                }
            }else{
                if(j < arr.length){
                    arr[j] = 0;
                }
                j--;
                if(j < arr.length){
                    arr[j] = 0;
                }
            }
        }
    }
}
```

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(1)
  - N as length of arr

```java
class Solution {
    public void duplicateZeros(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                shiftRight(i, arr);
                if(i != arr.length-1){
                    arr[i+1] = 0;
                    i++;
                }
            }
        }
    }

    public void shiftRight(int pos, int[] arr){
        for(int i = arr.length - 1; i > pos; i--){
            arr[i] = arr[i-1];
        }
    }
}
```
