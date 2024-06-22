# Finding Pairs With a Certain Sum

## FindSumPairs(int[] nums1, int[] nums2)

- Time Complexity: O(N)
- Space Complexity: O(N)
  - N as maximum length between nums1 and num2

## getUpdateFreqByKey(int key, int freq)

- Time Complexity: O(1)
- Space Complexity: O(1)

## add(int index, int val)

- Time Complexity: O(1)
- Space Complexity: O(1)

## count(int tot)

- Time Complexity: O(N)
- Space Complexity: O(1)
  - N as length of nums1

```java
class FindSumPairs {

    int[] nums1, nums2;
    HashMap<Integer, Integer> map;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        map = new HashMap();
        for(int num: nums2){
            getUpdateFreqByKey(num, 1);
        }
    }

    public void getUpdateFreqByKey(int key, int freq){
        map.put(key, map.getOrDefault(key, 0) + freq);
    }

    public void add(int index, int val) {
        getUpdateFreqByKey(nums2[index], -1);
        this.nums2[index] += val;
        getUpdateFreqByKey(nums2[index], 1);
    }

    public int count(int tot) {
        int res = 0;
        for(int num: nums1){
            res += map.getOrDefault(tot-num, 0);
        }
        return res;
    }

}
```
