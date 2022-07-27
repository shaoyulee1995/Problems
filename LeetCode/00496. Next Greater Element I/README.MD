# Monotonic Stack
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums2
```
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap();
        Stack<Integer> stack = new Stack<>();
        for(int num: nums2){
            while(!stack.isEmpty() && num > stack.peek()){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        int i = 0;
        for(int num: nums1){
            res[i++] = map.getOrDefault(num, -1);
        }
        return res;
    }
}
```