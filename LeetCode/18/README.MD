# 4Sum

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k){
        List<List<Integer>> res = new ArrayList();
        if(start == nums.length || k * nums[start] > target || k * nums[nums.length - 1] < target){
            return res;
        }
        if(k == 2){
            return twoSum(nums, start, target);
        }
        for(int i = start; i < nums.length; i++){
            if(i == start || nums[i-1] != nums[i]){
                for(var set : kSum(nums, target-nums[i], i+1, k-1)){
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(set);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, int target){
        List<List<Integer>> res = new ArrayList();
        int lo = start, hi = nums.length - 1;
        while(lo < hi){
            int sum = nums[lo] + nums[hi];
            if(sum < target || (lo > start && nums[lo] == nums[lo-1])){
                lo++;
            }else if(sum > target || hi < nums.length - 1 && nums[hi] == nums[hi+1]){
                hi--;
            }else{
                res.add(Arrays.asList(nums[lo], nums[hi]));
                lo++;
                hi--;
            }
        }
        return res;
    }
}
```

- Time Complexity: O(N<sup>4</sup>)
- Space Complexity: O(N<sup>4</sup>)
  - N as length of nums

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet();
        Arrays.sort(nums);
        for(int i = 0; i + 3 < nums.length; i++){
            if(nums[i] > 0 && nums[i] > target){
                return new ArrayList(res);
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i+1; j + 2 < nums.length; j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int k = j+1,
                    l = nums.length-1;
                while(k < l){
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while(k < l && nums[k] == nums[k+1]){
                            k++;
                        }
                        while(k < l && nums[l] == nums[l-1]){
                            l--;
                        }
                        k++;
                        l--;
                    }else if(sum < target){
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }
        return new ArrayList(res);
    }
}
```
