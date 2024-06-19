# Max Pair Sum in an Array

# HashMap

- Time Complexity: O(KlogK)
- Space Complexity: O(N)
  - N as length of nums
    - W as length of key in map

```
class Solution {
    public int maxSum(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        for(int num: nums){
            map.computeIfAbsent(getMaxDigit(num), x -> new ArrayList()).add(num);
        }
        int res = -1;
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            List<Integer> list = entry.getValue();
            if(list.size() < 2){
                continue;
            }
            Collections.sort(list);
            res = Math.max(res, list.get(list.size()-1) + list.get(list.size()-2));
        }
        return res;
    }

    public int getMaxDigit(int num){
        int res = Integer.MIN_VALUE;
        while(num > 0){
            res = Math.max(res, num%10);
            num /= 10;
        }
        return res;
    }
}
```
