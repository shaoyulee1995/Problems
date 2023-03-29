`# Java 8 ArrayList
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList();
        for(int i = 0; i < nums.length; i+=2){
            int freq = nums[i],
                val = nums[i+1];
            while(freq-- > 0){
                list.add(val);
            }
        }
        return list.stream().mapToInt(i-> i).toArray();
    }
}
```
# Array
* Time Complexity: O(N)
* Space Complexity: O(N)
	* N as length of nums
```
class Solution {
    public int[] decompressRLElist(int[] nums) {
        int sumFreq = 0;
        for(int i = 0; i < nums.length; i+=2){
            sumFreq += nums[i];
        }
        int[] res = new int[sumFreq];
        int index = 0;
        for(int i = 0; i < nums.length; i+=2){
            int freq = nums[i],
                val = nums[i+1];
            while(freq-- > 0){
                res[index++] = val;
            }
        }
        return res;
    }
}
```