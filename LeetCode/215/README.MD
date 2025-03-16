# Kth Largest Element in an Array

- Time Complexity: O(NlogN)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
```

- Time Complexity: O(Nlog(K))
- Space Complexity: O(K)
  - N as length of nums
  - K as k

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int num: nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}
```

- Time Complexity: O(N<sup>2</sup>)
- Space Complexity: O(1)
  - N as length of nums

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = 0,
            end = nums.length - 1,
            index = nums.length - k;
        while(start < end){
            int pivot = partition(nums, start, end);
            if(pivot == index){
                return nums[pivot];
            }else if(pivot < index){
                start = pivot + 1;
            }else if(pivot > index){
                end = pivot - 1;
            }
        }
        return nums[start];
    }

    public int partition(int[] nums, int start, int end){
        int pivot = start;
        while(start <= end){
            while(start <= end && nums[start] <= nums[pivot]){
                start++;
            }
            while(start <= end && nums[end] > nums[pivot]){
                end--;
            }
            if(end < start){
                break;
            }
            swap(nums, start, end);
        }
        swap(nums, pivot, end);
        return end;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int min = Integer.MAX_VALUE,
            max = Integer.MIN_VALUE;
        for(int num: nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] bucket = new int[max-min+1];
        for(int num: nums){
            bucket[num-min]++;
        }
        int remain = k;
        for(int i = bucket.length-1; i >= 0; i--){
            remain -= bucket[i];
            if(remain <= 0){
                return i + min;
            }
        }
        return -1;
    }
}
```