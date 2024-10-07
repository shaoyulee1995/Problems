# Sliding Window Maximum

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums

```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> list = new ArrayDeque();
        int idx = 0;
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++){
            while(!list.isEmpty() && i - k + 1 > list.peekFirst()){
                list.pollFirst();
            }
            while(!list.isEmpty() && nums[list.peekLast()] <= nums[i]){
                list.pollLast();
            }
            list.offerLast(i);
            if(i - k + 1 >= 0){
                res[idx++] = nums[list.peekFirst()];
            }
        }
        return res;
    }
}
```
- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as length of nums
```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        MyQueue link = new MyQueue();
        for(int i = 0; i < k; i++){
            link.add(nums[i]);
        }
        res[idx++] = link.peek();
        for(int i = k; i < nums.length; i++){
            link.poll(nums[i-k]);
            link.add(nums[i]);
            res[idx++] = link.peek();
        }
        return res;
    }
}

class MyQueue{
    Deque<Integer> deque;
    public MyQueue(){
        deque = new ArrayDeque();
    }

    public void add(int val){
        while(!deque.isEmpty() && val > deque.peekLast()){
            deque.pollLast();
        }
        deque.offerLast(val);
    }

    public int peek(){
        return deque.peekFirst();
    }

    public void poll(int val){
        if(!deque.isEmpty() && val == deque.peekFirst()){
            deque.pollFirst();
        }
    }
}
```